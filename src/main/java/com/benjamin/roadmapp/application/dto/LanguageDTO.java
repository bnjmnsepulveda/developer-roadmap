package com.benjamin.roadmapp.application.dto;

import com.benjamin.roadmapp.domain.entity.Language;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageDTO {

    private String id;
    private String name;

    public static LanguageDTO map(Language e) {
        return LanguageDTO.builder()
                .id(e.getId())
                .name(e.getName())
                .build();
    }
}
