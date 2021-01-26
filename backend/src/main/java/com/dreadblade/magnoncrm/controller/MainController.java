package com.dreadblade.magnoncrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api")
public class MainController {

    AtomicInteger counter = new AtomicInteger();

    @GetMapping(value = "/greeting")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return "{" +
                "\"id\": \"" + counter.getAndIncrement() + "\"," +
                "\"content\": \"Hello, " + name  +"!\"" +
                "}";
    }
}
