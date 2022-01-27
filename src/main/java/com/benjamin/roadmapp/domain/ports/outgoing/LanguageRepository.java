package com.benjamin.roadmapp.domain.ports.outgoing;

import com.benjamin.roadmapp.domain.entity.Language;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository {

    Language save(Language language);
    Optional<Language> findById(String id);
    List<Language> findAll();
    List<Language> findByIds(List<String> ids);
}
