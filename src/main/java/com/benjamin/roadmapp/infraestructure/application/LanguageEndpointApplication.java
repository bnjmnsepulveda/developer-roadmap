package com.benjamin.roadmapp.infraestructure.application;

import com.benjamin.roadmapp.application.LanguageEndpoint;
import com.benjamin.roadmapp.application.dto.CreateLanguageDTO;
import com.benjamin.roadmapp.application.dto.LanguageDTO;
import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class LanguageEndpointApplication implements LanguageEndpoint {

    @Autowired
    private LanguageService service;

    @Override
    public LanguageDTO create(CreateLanguageDTO language) {
        var uuid = UUID.randomUUID().toString();
        var newLanguage = Language.builder()
                .properties(language.getProperties())
                .name(language.getName())
                .id(uuid)
                .build();
        var entity = service.create(newLanguage);
        return LanguageDTO.map(entity);

    }

    @Override
    public List<LanguageDTO> findAll() {
        return service
                .findAll()
                .stream()
                .map(LanguageDTO::map)
                .collect(Collectors.toList());
    }
}
