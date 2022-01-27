package com.benjamin.roadmapp.infraestructure.application;

import com.benjamin.roadmapp.application.AddLanguage;
import com.benjamin.roadmapp.application.FindLanguages;
import com.benjamin.roadmapp.application.dto.CreateLanguageDTO;
import com.benjamin.roadmapp.application.dto.LanguageDTO;
import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.ports.outgoing.GenerateUniqueID;
import com.benjamin.roadmapp.domain.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class LanguageEndpoint implements AddLanguage, FindLanguages {

    @Autowired
    private LanguageService service;
    @Autowired
    private GenerateUniqueID generateUniqueID;

    @Override
    public LanguageDTO create(CreateLanguageDTO createLanguageDTO) {
        var id = generateUniqueID.handle();
        var newLanguage = Language.builder()
                .properties(createLanguageDTO.getProperties())
                .name(createLanguageDTO.getName())
                .id(id)
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
