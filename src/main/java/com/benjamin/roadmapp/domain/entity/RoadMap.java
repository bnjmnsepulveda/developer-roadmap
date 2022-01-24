package com.benjamin.roadmapp.domain.entity;

import lombok.Data;

import java.util.List;

@Data
public class RoadMap {
    private String name;
    private String description;
    private List<Language> languagesToDomain;
    private List<Knowledge> knowledgeToDomain;
}
