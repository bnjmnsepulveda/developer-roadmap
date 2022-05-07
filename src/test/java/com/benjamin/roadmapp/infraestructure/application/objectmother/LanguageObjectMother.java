package com.benjamin.roadmapp.infraestructure.application.objectmother;

import com.benjamin.roadmapp.domain.entity.Language;

import java.util.Arrays;

public class LanguageObjectMother {

    public static Language buildLanguage(String id, String name, String... properties) {
        return Language.builder()
                .id(id)
                .name(name)
                .properties(Arrays.asList(properties))
                .build();
    }

}
