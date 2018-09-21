package com.ferrero.producer.controllers;

import com.ferrero.producer.events.model.Greetings;
import com.ferrero.producer.events.source.GreetingsSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SimpleController {

    private final GreetingsSource greetingsSource;

    @Autowired
    public SimpleController(GreetingsSource greetingsSource) {
        this.greetingsSource = greetingsSource;
    }

    @GetMapping("/greeting/{name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void publish(@PathVariable String name) {
        log.info("Ricevuto richiesta di invio messaggio!");
        String message = "Hello "+ name +"!";

        Greetings greetings = Greetings.builder()
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();

        greetingsSource.sendGreeting(greetings);
    }


}
