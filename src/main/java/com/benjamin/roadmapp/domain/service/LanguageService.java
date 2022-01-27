package com.benjamin.roadmapp.domain.service;

import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.ports.outgoing.LanguageRepository;
import com.benjamin.roadmapp.domain.exception.EntityNotFound;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class LanguageService {

    private LanguageRepository repository;

    public Language create(Language language) {
        return repository.save(language);
    }

    public Language findById(String id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFound("Language(id='" + id + "') not found"));
    }

    public List<Language> findByIds(List<String> ids) {
        return repository.findByIds(ids);
    }

    public List<Language> findAll() {
        return repository.findAll();
    }

}
