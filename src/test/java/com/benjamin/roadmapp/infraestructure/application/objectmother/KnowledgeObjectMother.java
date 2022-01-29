package com.benjamin.roadmapp.infraestructure.application.objectmother;

import com.benjamin.roadmapp.domain.entity.Knowledge;

import java.util.List;

public class KnowledgeObjectMother {

    public static Knowledge buildKnowledge(String id, String name){
        return Knowledge.builder()
                .id(id)
                .name(name)
                .build();
    }

    public static Knowledge buildKnowledge(String id, String name, List<Knowledge> nextToLearn){
        return Knowledge.builder()
                .id(id)
                .name(name)
                .nextKnowledgeToLearn(nextToLearn)
                .build();
    }
}
