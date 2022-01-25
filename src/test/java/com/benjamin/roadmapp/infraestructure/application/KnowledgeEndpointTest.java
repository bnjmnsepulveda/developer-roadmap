package com.benjamin.roadmapp.infraestructure.application;

import com.benjamin.roadmapp.application.dto.CreateKnowledgeDTO;
import com.benjamin.roadmapp.domain.entity.Knowledge;
import com.benjamin.roadmapp.domain.service.KnowledgeService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@Log4j2
@ExtendWith(MockitoExtension.class)
class KnowledgeEndpointTest {

    @Mock
    KnowledgeService service;


    @Test
    void createTest() {

        when(service.create(Mockito.any()))
                .thenReturn(buildKnowledge("1","java"));

        var app = new KnowledgeEndpointApplication(service);

        var result = app.create(new CreateKnowledgeDTO("java"));
        assertThat(result.getName()).isEqualTo("java");
        assertThat(result.getId()).isNotNull();

    }

    @Test
    void findAllTest(){

        when(service.findAll()).thenReturn(Arrays.asList(
                buildKnowledge("1","http"),
                buildKnowledge("2","browser")
        ));

        var app = new KnowledgeEndpointApplication(service);
        var result =  app.findAll();
        assertThat(result.size()).isEqualTo(2);

    }

    Knowledge buildKnowledge(String id, String name){
        return Knowledge.builder()
                .id(id)
                .name(name)
                .build();
    }
}
