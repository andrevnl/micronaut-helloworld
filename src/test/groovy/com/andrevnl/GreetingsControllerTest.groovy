package com.andrevnl

import com.andrevnl.routes.GreetingsControllerRoutes
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification
import javax.inject.Inject

@MicronautTest
class GreetingsControllerTest extends Specification {

    @Inject
    EmbeddedServer embeddedServer

    @Inject
    @Client("/greetings")
    GreetingsControllerRoutes client

    void 'test Index'() {
        given:
        RxHttpClient client = embeddedServer.getApplicationContext().createBean(RxHttpClient.class, embeddedServer.getURL())

        expect:
        HttpStatus.OK == client.toBlocking().exchange("/greetings").status()
    }

    void 'greetings By Name Test'() {
        given:
        HttpResponse<String> response = client.greeting("André")

        expect:
        response.body() == "Olá André!"
    }
}
