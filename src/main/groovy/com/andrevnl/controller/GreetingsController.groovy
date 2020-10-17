package com.andrevnl.controller

import com.andrevnl.routes.GreetingsControllerRoutes
import io.micronaut.context.annotation.Value
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/greetings")
class GreetingsController implements GreetingsControllerRoutes {

    @Get("/")
    HttpStatus index() {
        HttpStatus.OK
    }

    @Override
    HttpResponse<String> greeting(String name) {
        return HttpResponse.ok("Olá ${name}!")
    }
}
