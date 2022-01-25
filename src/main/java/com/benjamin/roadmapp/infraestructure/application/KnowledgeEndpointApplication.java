package com.benjamin.roadmapp.infraestructure.application;

import com.benjamin.roadmapp.application.KnowledgeEndpoint;
import com.benjamin.roadmapp.application.dto.CreateKnowledgeDTO;
import com.benjamin.roadmapp.application.dto.KnowledgeDTO;
import com.benjamin.roadmapp.domain.entity.Knowledge;
import com.benjamin.roadmapp.domain.service.KnowledgeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class KnowledgeEndpointApplication implements KnowledgeEndpoint {

    @Autowired
    private KnowledgeService service;

    @Override
    public KnowledgeDTO create(CreateKnowledgeDTO createKnowledge) {
        var uuid = UUID.randomUUID().toString();
        var newEntity = Knowledge.builder()
                .id(uuid)
                .name(createKnowledge.getName())
                .build();
        var entity = service.create(newEntity);
        return KnowledgeDTO.builder()
                .name(entity.getName())
                .id(entity.getId())
                .build();
    }

    @Override
    public List<KnowledgeDTO> findAll() {
        return service
                .findAll()
                .stream()
                .map(k -> KnowledgeDTO.builder()
                        .id(k.getId())
                        .name(k.getName())
                        .build())
                .collect(Collectors.toList());
    }
}
