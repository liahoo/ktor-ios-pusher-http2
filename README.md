# ktor-ios-pusher-http2

### A Ktor project using _`Jetty`_ http client with *`com.clevertap.apns:apns-http2`* to send push notification to iOS devices.

Anyone wants to use it for his own iOS app, the following steps should be done:
* Follow up the guide from https://ktor.io/advanced/http2.html to enable `HTTP/2` with `alph-boot`, which is required by `apns-http2`
* Upload a .p12 file and which should be exported from Push Notification Service certificate in KeyChain access.
* Put the .p12 file to root folder and rename it to PushNotification.p12.(If you use another path, change ApnsUtils.buildClient to use it)
* In src/ApnsUtils.kt file, change the topic to your bundle id:
```
        return ApnsClientBuilder()
            .withProductionGateway()
            .inSynchronousMode()
            .withCertificate(cert)
            .withPassword("")
            .withDefaultTopic("You.Bundle.Id")
            .build()
```

### Enjoy!