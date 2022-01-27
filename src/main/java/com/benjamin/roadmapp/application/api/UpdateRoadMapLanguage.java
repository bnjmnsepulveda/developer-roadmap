package com.benjamin.roadmapp.application.api;

import com.benjamin.roadmapp.application.dto.RoadMapLanguageUpdatedDTO;

import java.util.List;

public interface UpdateRoadMapLanguage {
    RoadMapLanguageUpdatedDTO updateLanguage(String id, List<String> languageIds);
}
