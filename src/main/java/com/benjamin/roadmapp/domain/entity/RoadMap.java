package com.benjamin.roadmapp.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoadMap {
    private String id;
    private String name;
    private String description;
    private List<Language> languagesToDomain;
    private List<Knowledge> knowledgeToDomain;
}
