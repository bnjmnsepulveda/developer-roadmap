package com.benjamin.roadmapp.infraestructure.application.api.restcontroller;

import com.benjamin.roadmapp.application.dto.LanguageDTO;
import com.benjamin.roadmapp.infraestructure.application.api.service.LanguageEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/languages")
public class LanguageRestController {

    @Autowired
    private LanguageEndpointService service;

    @GetMapping
    public Flux<LanguageDTO> get() {
        return Flux.fromIterable(service.findAll());
    }

}
