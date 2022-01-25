package com.benjamin.roadmapp.application.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CreateLanguageDTO {
    private String name;
    private List<String> properties;
}
