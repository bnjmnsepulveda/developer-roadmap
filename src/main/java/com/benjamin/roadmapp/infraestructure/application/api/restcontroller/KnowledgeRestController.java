package com.benjamin.roadmapp.infraestructure.application.api.restcontroller;

import com.benjamin.roadmapp.application.dto.CreateKnowledgeDTO;
import com.benjamin.roadmapp.application.dto.KnowledgeDTO;
import com.benjamin.roadmapp.infraestructure.application.api.service.KnowledgeEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/knowledge")
public class KnowledgeRestController {

    @Autowired
    private KnowledgeEndpointService service;

    @PostMapping
    public Mono<KnowledgeDTO> create(@RequestBody CreateKnowledgeDTO createKnowledgeRequest) {
        return Mono.just(service.create(createKnowledgeRequest));
    }

    @GetMapping
    public Flux<KnowledgeDTO> get() {
        return Flux.fromIterable(service.findAll());
    }
}
