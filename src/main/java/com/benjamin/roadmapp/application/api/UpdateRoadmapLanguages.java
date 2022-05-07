package com.benjamin.roadmapp.application.api;


import java.util.List;


public interface UpdateRoadmapLanguages {
    boolean updateLanguages(String id, List<String> languageIds);
}
