package com.benjamin.roadmapp.application;

import com.benjamin.roadmapp.application.dto.CreateLanguageDTO;
import com.benjamin.roadmapp.application.dto.LanguageDTO;

public interface AddLanguage {

    LanguageDTO create(CreateLanguageDTO createLanguageDTO);

}
