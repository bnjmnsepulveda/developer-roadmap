package com.benjamin.roadmapp.infraestructure.application.api.service;

import com.benjamin.roadmapp.application.api.AddLanguage;
import com.benjamin.roadmapp.application.api.FindLanguages;
import com.benjamin.roadmapp.application.dto.CreateLanguageDTO;
import com.benjamin.roadmapp.application.dto.LanguageDTO;
import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.ports.outgoing.GenerateUniqueID;
import com.benjamin.roadmapp.domain.service.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LanguageEndpointService implements AddLanguage, FindLanguages {

    @Autowired
    private LanguageService service;
    @Autowired
    private GenerateUniqueID generateUniqueID;

    @Override
    public LanguageDTO create(CreateLanguageDTO createLanguageDTO) {
        var newLanguage = Language.builder()
                .id(generateUniqueID.handle())
                .properties(createLanguageDTO.getProperties())
                .name(createLanguageDTO.getName())
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
