package com.benjamin.roadmapp.infraestructure.application;

import com.benjamin.roadmapp.application.dto.CreateKnowledgeDTO;
import com.benjamin.roadmapp.domain.ports.outgoing.GenerateUniqueID;
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
    @Mock
    GenerateUniqueID generateUniqueID;

    @Test
    void createTest() {
        when(service.create(Mockito.any()))
                .thenReturn(buildKnowledge("1","java"));
        when(generateUniqueID.handle())
                .thenReturn("unique-id");
        var app = new KnowledgeEndpointService(service, generateUniqueID);

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

        var app = new KnowledgeEndpointService(service, generateUniqueID);
        var result =  app.findAll();
        assertThat(result.size()).isEqualTo(2);

    }


}
