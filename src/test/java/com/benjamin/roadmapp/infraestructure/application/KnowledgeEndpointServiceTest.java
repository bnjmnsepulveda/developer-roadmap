package com.benjamin.roadmapp.infraestructure.application;

import com.benjamin.roadmapp.application.dto.CreateKnowledgeDTO;
import com.benjamin.roadmapp.domain.service.KnowledgeService;
import com.benjamin.roadmapp.infraestructure.application.api.service.KnowledgeEndpointService;
import com.benjamin.roadmapp.utils.UnitTestBase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.Arrays;

import static com.benjamin.roadmapp.infraestructure.application.objectmother.KnowledgeObjectMother.buildKnowledge;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class KnowledgeEndpointServiceTest extends UnitTestBase {

    @Mock
    KnowledgeService service;

    @Test
    void createTest() {
        when(service.create(Mockito.any()))
                .thenReturn(buildKnowledge("java"));
        var app = new KnowledgeEndpointService(service);

        var result = app.create(new CreateKnowledgeDTO("java"));
        assertThat(result.getName()).isEqualTo("java");

    }

    @Test
    void findAllTest(){

        when(service.findAll()).thenReturn(Arrays.asList(
                buildKnowledge("http"),
                buildKnowledge("browser")
        ));

        var app = new KnowledgeEndpointService(service);
        var result =  app.findAll();
        assertThat(result.size()).isEqualTo(2);

    }


}
