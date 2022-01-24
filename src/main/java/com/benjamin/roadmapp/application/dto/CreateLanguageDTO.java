package com.benjamin.roadmapp.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateLanguageDTO {
    private String name;
    private List<String> properties;
}
