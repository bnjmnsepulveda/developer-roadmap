package com.benjamin.roadmapp.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoadMapDTO {
    private String id;
    private String name;
    private String description;
    private List<LanguageDTO> languagesToDomain;
    private List<KnowledgeDTO> knowledgeToDomain;
}
