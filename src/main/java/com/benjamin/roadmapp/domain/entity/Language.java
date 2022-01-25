package com.benjamin.roadmapp.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Language {
    private String id;
    private String name;
    private List<String> properties;
}
