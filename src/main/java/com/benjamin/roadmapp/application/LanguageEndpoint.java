package com.benjamin.roadmapp.application;

import com.benjamin.roadmapp.application.dto.CreateLanguageDTO;
import com.benjamin.roadmapp.application.dto.LanguageDTO;

import java.util.List;

public interface LanguageEndpoint {

    LanguageDTO create(CreateLanguageDTO language);
    List<LanguageDTO> findAll();

}
