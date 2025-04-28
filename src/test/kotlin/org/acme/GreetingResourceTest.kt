package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.eclipse.microprofile.config.ConfigProvider
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test

@QuarkusTest
class GreetingResourceTest {

    companion object {
        const val BATCH_QUEUE_PROP_V1 = "batch-queue.queue-url"
        const val BATCH_QUEUE_PROP_V2 = "batch.queue-url"
    }

    @Test
    fun testHelloEndpoint() {
        given()
          .`when`().get("/hello")
          .then()
             .statusCode(200)
             .body(`is`("Hello from Quarkus REST"))
    }


    @Test
    fun testingPropertyValues() {
        val actualQueueUrlV1 = getRawValue(BATCH_QUEUE_PROP_V1)
        val actualQueueUrlV2 = getRawValue(BATCH_QUEUE_PROP_V2)

        println("actualQueueUrlV1: $actualQueueUrlV1")
        println("actualQueueUrlV2: $actualQueueUrlV2")

        assert(actualQueueUrlV1 == actualQueueUrlV2)
    }

    private fun getRawValue(prop: String): String {
        return ConfigProvider.getConfig()
            .getConfigValue(prop)
            .rawValue
    }
}
