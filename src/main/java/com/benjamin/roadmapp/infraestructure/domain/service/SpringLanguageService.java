package com.benjamin.roadmapp.infraestructure.domain.service;

import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.service.LanguageService;
import com.benjamin.roadmapp.infraestructure.exception.EntityNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SpringLanguageService implements LanguageService {

    private Map<String, Language> data = new HashMap<>();

    @Override
    public Language create(Language language) {
        return data.put(language.getId(),language);
    }

    @Override
    public Language findById(String id) {
        var entityFound = data.get(id);
        if (entityFound == null) {
            throw new EntityNotFound("Language(id='" + id + "') not found");
        }
        return entityFound;
    }

    @Override
    public List<Language> findByIds(List<String> ids) {
        return data
                .values()
                .stream()
                .filter(language -> ids.contains(language.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Language> findAll() {
        return new ArrayList<>(data.values());
    }
}
