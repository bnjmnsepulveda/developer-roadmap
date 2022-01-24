package com.benjamin.roadmapp.domain.entity;

import lombok.Data;

import java.util.List;

@Data
public class Language {
    private String name;
    private List<String> properties;
    private List<LearningResource> learningResources;
    private List<Framework> availableFrameworks;
}
