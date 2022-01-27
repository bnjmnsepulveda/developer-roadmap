package com.benjamin.roadmapp.domain.service;

import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.ports.incoming.DomainService;
import com.benjamin.roadmapp.domain.ports.outgoing.LanguageRepository;
import com.benjamin.roadmapp.domain.exception.EntityNotFound;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class LanguageService implements DomainService<Language> {

    private LanguageRepository repository;

    @Override
    public Language create(Language language) {
        return repository.save(language);
    }

    @Override
    public Language findById(String id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFound("Language(id='" + id + "') not found"));
    }

    @Override
    public List<Language> findAll() {
        return repository.findAll();
    }

    public List<Language> findByIds(List<String> ids) {
        return repository.findByIds(ids);
    }

}
