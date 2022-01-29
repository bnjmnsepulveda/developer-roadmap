package com.benjamin.roadmapp.infraestructure.neo4j;

import com.benjamin.roadmapp.infraestructure.application.objectmother.KnowledgeObjectMother;
import com.benjamin.roadmapp.utils.UnitTestBase;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
public class KnowledgeNodeTest extends UnitTestBase {

    @Test
    void mapTest(){

        var knowledgeWith2KnowledgeToLearn = KnowledgeObjectMother.buildKnowledge(
                "1",
                "http",
                Arrays.asList(
                        KnowledgeObjectMother.buildKnowledge("2","webserver"),
                        KnowledgeObjectMother.buildKnowledge("3","basic html css")
                ));

        var result = KnowledgeNode.map(knowledgeWith2KnowledgeToLearn);

        assertThat(result.getName()).isEqualTo("http");
        assertThat(result.getNextToLearn().size()).isEqualTo(2);

        var knowledgeWithNullTextToLearn = KnowledgeObjectMother.buildKnowledge("1", "http");
        result = KnowledgeNode.map(knowledgeWithNullTextToLearn);

        assertThat(result.getNextToLearn()).isNull();

    }

    @Test
    void toEntity(){
        var n = KnowledgeNode.builder()
                .name("java")
                .nextToLearn(
                        Arrays.asList(
                                KnowledgeNode.builder().name("spring").build(),
                                KnowledgeNode.builder().name("micronaut").build(),
                                KnowledgeNode.builder().name("spark").build()
                        )
                )
                .build();

        var result = KnowledgeNode.toEntity(n);
        System.out.println(result);
        assertThat(result.getName()).isEqualTo("java");
        assertThat(result.getId()).isEqualTo("java");
        assertThat(result.getNextKnowledgeToLearn()).isNotNull();
        assertThat(result.getNextKnowledgeToLearn().size()).isEqualTo(3);

    }
}
