package com.benjamin.roadmapp.infraestructure.application.objectmother;

import com.benjamin.roadmapp.domain.entity.Knowledge;

public class KnowledgeObjectMother {

    public static Knowledge buildKnowledge(String id, String name){
        return Knowledge.builder()
                .id(id)
                .name(name)
                .build();
    }
}
