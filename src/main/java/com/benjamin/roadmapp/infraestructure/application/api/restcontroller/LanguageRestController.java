package com.benjamin.roadmapp.infraestructure.application.api.restcontroller;

import com.benjamin.roadmapp.application.dto.CreateLanguageDTO;
import com.benjamin.roadmapp.application.dto.LanguageDTO;
import com.benjamin.roadmapp.infraestructure.application.api.service.LanguageEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/languages")
public class LanguageRestController {

    @Autowired
    private LanguageEndpointService service;

    @GetMapping
    public Flux<LanguageDTO> get() {
        return Flux.fromIterable(service.findAll());
    }

    @PostMapping
    public Mono<LanguageDTO> create(@RequestBody CreateLanguageDTO createLanguageRequest){
        return Mono.just(service.create(createLanguageRequest));
    }



}
