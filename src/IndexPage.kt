package com.fascode

import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.*

class IndexPage: Template<HTML> {
    var token: String? = null
    override fun HTML.apply() {
        head {
            insert(HeadBlock()){

            }
        }
        body {
            ol(classes="breadcrumb") {
                li(classes="breadcrumb-item active") {
                    +("Pusher")
                }
            }
            div(classes="container") {
                h2 {
                    +("Push Messages")
                }
                form(action="/Push/Message", method= FormMethod.post) {
                    div(classes="input-group mb-3") {
                        div(classes="input-group-prepend") {
                            span(classes="input-group-text") {
                                +("Device Token")
                            }
                        }
                        input(type=InputType.text, classes="form-control", name="token") {
                            id="token"
                            placeholder="Device Token"
                            required=true
                            token?.let { value = it }

                        }
                    }
                    div(classes="input-group mb-3") {
                        div(classes="input-group-prepend") {
                            span(classes="input-group-text") {
                                +("Title")
                            }
                        }
                        input(type=InputType.text, classes="form-control", name="message") {
                            id="title"
                            placeholder="Title"
                            required=true
                        }
                    }
                    div(classes="input-group mb-3") {
                        div(classes="input-group-prepend") {
                            span(classes="input-group-text") {
                                +("Body")
                            }
                        }
                        input(type=InputType.text, classes="form-control", name="message") {
                            id="body"
                            placeholder="Body"

                        }
                    }
                    button(classes="btn btn-primary btn-rounded waves-effect", type=ButtonType.submit) {
                        +("Send Message")
                    }
                }
                h2 {
                    +("Uninstall checking")
                }
                form(action="/Push/Uninstall", method= FormMethod.post) {
                    div(classes="input-group mb-3") {
                        div(classes="input-group-prepend") {
                            span(classes="input-group-text") {
                                +("Device Token")
                            }
                        }
                        input(type=InputType.text, classes="form-control", name="token") {
                            id="token"
                            placeholder="Device Token"
                            required=true
                            token?.let { value = it }

                        }
                    }
                    button(classes="btn btn-primary btn-rounded waves-effect", type=ButtonType.submit) {
                        +("Push for uninstall checking")
                    }
                }
            }

        }
    }

}