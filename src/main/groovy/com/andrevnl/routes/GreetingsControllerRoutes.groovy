package com.andrevnl.routes

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get

interface GreetingsControllerRoutes {

    @Get("/{name}")
    HttpResponse<String> greeting(String name)
}