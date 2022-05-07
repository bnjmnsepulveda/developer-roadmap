package com.benjamin.roadmapp.infraestructure.application.objectmother;

import com.benjamin.roadmapp.domain.entity.Knowledge;

import java.util.List;

public class KnowledgeObjectMother {

    public static Knowledge buildKnowledge( String name){
        return Knowledge.builder()
                .name(name)
                .build();
    }

    public static Knowledge buildKnowledge( String name, List<Knowledge> nextToLearn){
        return Knowledge.builder()
                .name(name)
                .nextKnowledgeToLearn(nextToLearn)
                .build();
    }
}
