package com.benjamin.roadmapp.infraestructure.application.api.restcontroller;

import com.benjamin.roadmapp.application.dto.CreateRoadMapDTO;
import com.benjamin.roadmapp.application.dto.RoadMapDTO;
import com.benjamin.roadmapp.application.dto.RoadMapKnowledgeUpdatedDTO;
import com.benjamin.roadmapp.domain.exception.RoadMapNotFoundException;
import com.benjamin.roadmapp.infraestructure.application.api.service.RoadMapEndpointService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/roadmap")
public class RoadMapRestController {
    @Autowired
    RoadMapEndpointService service;

    @PostMapping
    public Mono<RoadMapDTO> create(@RequestBody CreateRoadMapDTO createRoadMapRequest){
        return Mono.just(service.create(createRoadMapRequest));
    }

    @GetMapping
    public Flux<RoadMapDTO> get() {
        return Flux.fromIterable(service.findAll());
    }

    @GetMapping("/{id}/update/knowledge")
    public Mono<RoadMapKnowledgeUpdatedDTO> updateKnowledge(@PathVariable("id") String id, @RequestParam List<String> knowledgeIds) {
        log.info("updating {} roadmap with knowledge {}", id, knowledgeIds);
        return Mono.just(service.updateKnowledge(id, knowledgeIds));
    }

    @ExceptionHandler(RoadMapNotFoundException.class)
    public ResponseEntity<String> handleRoadMapNotFoundException(RoadMapNotFoundException re) {
        return new ResponseEntity<>(re.getMessage(), HttpStatus.NOT_FOUND);
    }
}
