package com.benjamin.roadmapp.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageDTO {
    private String id;
    private String name;
}
