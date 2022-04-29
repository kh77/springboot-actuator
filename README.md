# Spring boot Actuator Project
## Endpoints:
http://localhost:8080/actuator


http://localhost:8080/actuator/info

on Runtime, we can add more information in 'info' endpoint. Check this class UserStatusCountContributor

http://localhost:8080/actuator/loggers

hit 'loggers' end point and see the log level, change the log level of "com.sm.repo" package then you will it is in "configuredLevel": "INFO" level.
you can change this log level to debug in runtime call using POST call.


curl --location --request POST 'http://localhost:8080/actuator/loggers/com.sm.repo' \
--header 'Content-Type: application/json' \
--data-raw '   {"configuredLevel": "DEBUG"}'


http://localhost:8080/actuator/health

There is CustomServerHealthIndicator class that info will be shown in 'health' endpoint
```json
{
  "status": "UP",
  "components": {
    "customServer": {
      "status": "UP"
    },
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 249059262464,
        "free": 27353088,
        "threshold": 10485760,
        "exists": true
      }
    },
    "ping": {
      "status": "UP"
    }
  }
}
````

Custom endpoint: 

CRUD operation here. Check CustomEndpoint class in monitor package

## list of release-notes
http://localhost:8080/actuator/release-notes


## get release-notes by version
http://localhost:8080/actuator/release-notes/v-1.0