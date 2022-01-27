package com.benjamin.roadmapp.infraestructure.application.api.service;

import com.benjamin.roadmapp.application.AddKnowledge;
import com.benjamin.roadmapp.application.FindKnowledge;
import com.benjamin.roadmapp.application.dto.CreateKnowledgeDTO;
import com.benjamin.roadmapp.application.dto.KnowledgeDTO;
import com.benjamin.roadmapp.domain.entity.Knowledge;
import com.benjamin.roadmapp.domain.ports.outgoing.GenerateUniqueID;
import com.benjamin.roadmapp.domain.service.KnowledgeService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
@AllArgsConstructor
public class KnowledgeEndpointService implements AddKnowledge, FindKnowledge {

    @Autowired
    private KnowledgeService service;
    @Autowired
    private GenerateUniqueID generateUniqueID;

    @Override
    public KnowledgeDTO create(CreateKnowledgeDTO createKnowledge) {
        var id = generateUniqueID.handle();
        var newEntity = Knowledge.builder()
                .id(id)
                .name(createKnowledge.getName())
                .build();
        var entity = service.create(newEntity);
        return KnowledgeDTO.map(entity);
    }

    @Override
    public List<KnowledgeDTO> findAll() {
        return service
                .findAll()
                .stream()
                .map(KnowledgeDTO::map)
                .collect(Collectors.toList());
    }
}
