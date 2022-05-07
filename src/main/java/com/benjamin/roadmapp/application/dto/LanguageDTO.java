package com.benjamin.roadmapp.application.dto;

import com.benjamin.roadmapp.domain.entity.Language;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LanguageDTO {

    private String id;
    private String name;
    private List<String> properties;

    public static LanguageDTO map(Language e) {
        return LanguageDTO.builder()
                .id(e.getId())
                .name(e.getName())
                .properties(e.getProperties())
                .build();
    }
}
