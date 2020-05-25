package com.fascode

import com.clevertap.apns.ApnsClient
import com.clevertap.apns.Notification
import com.clevertap.apns.NotificationResponse
import com.clevertap.apns.clients.ApnsClientBuilder
import java.io.FileInputStream

object ApnsUtils {
    fun buildClient() : ApnsClient {
        val cert = FileInputStream("PushNotification.p12")
        return ApnsClientBuilder()
            .withProductionGateway()
            .inSynchronousMode()
            .withCertificate(cert)
            .withPassword("")
            .withDefaultTopic("com.fascode.attributable")
            .build()

    }
    fun verifyUninstall(token: String) : NotificationResponse {
        return buildClient().push(createSilentPushForUninstallCheck(token))
    }

    fun sendMessageToDevice(token: String, title: String, body: String): NotificationResponse {
        val notification = Notification.Builder(token)
            .alertTitle(title)
            .alertBody(body)
            .contentAvailable()
            .build()
        return buildClient().push(notification)
    }
    fun createSilentPushForUninstallCheck(token: String): Notification =
        Notification.Builder(token)
            .contentAvailable(false)
            .build()
}