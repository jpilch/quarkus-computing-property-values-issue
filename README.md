## Command for successful build

```shell script
./gradlew clean build \
        --stacktrace \
        -Dquarkus.test.native-image-profile=test \
        -Dquarkus.test.profile=test \
        -Dquarkus.test.integration-test-profile=test \
        -Dquarkus.package.jar.enabled=true \
        -Dquarkus.profile=prod \
        -Dquarkus.native.enabled=false
```


## Command for failing build

```shell script
BATCH_QUEUE_URL=dummy ./gradlew clean build \
        --stacktrace \
        -Dquarkus.test.native-image-profile=test \
        -Dquarkus.test.profile=test \
        -Dquarkus.test.integration-test-profile=test \
        -Dquarkus.package.jar.enabled=true \
        -Dquarkus.profile=prod \
        -Dquarkus.native.enabled=false
```
