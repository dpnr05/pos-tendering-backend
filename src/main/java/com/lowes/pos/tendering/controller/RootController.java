package com.lowes.pos.tendering.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RootController {

    @GetMapping("/")
    public Mono<String> home() {
        return Mono.just("POS Tendering Backend is running 🚀");
    }

    @GetMapping("/health")
    public Mono<String> health() {
        return Mono.just("UP");
    }
}
