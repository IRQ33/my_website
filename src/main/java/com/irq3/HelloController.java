package com.irq3;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class HelloController {

    @Get(produces = MediaType.TEXT_HTML)
    public String heyo(){
        return "Heyo, website is not ready!";
    }
}
