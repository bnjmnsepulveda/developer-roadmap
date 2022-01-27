package com.benjamin.roadmapp.application.api;

import com.benjamin.roadmapp.application.dto.LanguageDTO;

import java.util.List;

public interface FindLanguages {

    List<LanguageDTO> findAll();

}
