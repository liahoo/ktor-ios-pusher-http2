package com.fascode

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import freemarker.cache.*
import io.ktor.freemarker.*
import io.ktor.content.*
import io.ktor.http.content.*
import io.ktor.gson.*
import io.ktor.features.*
import io.ktor.client.*
import io.ktor.client.engine.jetty.*
import io.ktor.html.respondHtmlTemplate

fun main(args: Array<String>): Unit = io.ktor.server.jetty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    install(ContentNegotiation) {
        gson {
        }
    }

    val client = HttpClient(Jetty) {
    }

    routing {
        get("/") {
            call.respondHtmlTemplate(IndexPage()){
                token = call.request.queryParameters["token"]
            }
        }
        post("/Push/Message") {
            val params = call.receiveParameters()
            params["token"]?.let { token->
                val title = params["title"] ?: ""
                val body = params["message"] ?: ""
                val result = ApnsUtils.sendMessageToDevice(token, title, body )
                call.respondHtmlTemplate(ResultPage(result)) {
                    this.token = token
                }
            } ?: call.respond(HttpStatusCode.BadRequest, "token is not set")
        }
        post("/Push/Uninstall") {
            val params = call.receiveParameters()
            params["token"]?.let { token ->
                val result = ApnsUtils.verifyUninstall(token )
                call.respondHtmlTemplate(ResultPage(result)) {
                    this.token = token
                }
            } ?: call.respond(HttpStatusCode.BadRequest, "token is not set")
        }

        // Static feature. Try to access `/static/ktor_logo.svg`
        static("/static") {
            resources("static")
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}
