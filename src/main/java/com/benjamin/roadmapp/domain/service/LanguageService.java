package com.benjamin.roadmapp.domain.service;

import com.benjamin.roadmapp.domain.entity.Language;

import java.util.List;

public interface LanguageService {

    void create(Language language);
    Language findById(String id);
    List<Language> findAll();

}
