package com.benjamin.roadmapp.infraestructure.domain.adapter;

import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.ports.outgoing.LanguageRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    private Map<String, Language> data = new ConcurrentHashMap<>();

    @Override
    public Language save(Language language) {
        return data.put(language.getId(), language);
    }

    @Override
    public Optional<Language> findById(String id) {
        return Optional.of(data.get(id));
    }

    @Override
    public List<Language> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public List<Language> findByIds(List<String> ids) {
        return data
                .values()
                .stream()
                .filter(ids::contains)
                .collect(Collectors.toList());
    }
}
