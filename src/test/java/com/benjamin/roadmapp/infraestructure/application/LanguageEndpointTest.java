package com.benjamin.roadmapp.infraestructure.application;

import com.benjamin.roadmapp.application.dto.CreateLanguageDTO;
import com.benjamin.roadmapp.domain.service.LanguageService;
import com.benjamin.roadmapp.utils.UnitTestBase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;

import static com.benjamin.roadmapp.infraestructure.application.objectmother.LanguageObjectMother.buildLanguage;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class LanguageEndpointTest extends UnitTestBase {

    @Mock
    LanguageService service;

    @Test
    void createTest() {
        when(service.create(Mockito.any())).thenReturn(buildLanguage("1", "java","safe typing", "streams API"));
        var app = new LanguageEndpointApplication(service);
        var result = app.create(CreateLanguageDTO.builder()
                        .name("java")
                .build());
        assertThat(result.getName()).isEqualTo("java");

    }

    @Test
    void findAllTest(){
        when(service.findAll()).thenReturn(Arrays.asList(
                buildLanguage("1","java"),
                buildLanguage("2","python","dynamic typing")
        ));

        var app = new LanguageEndpointApplication(service);
        var result =  app.findAll();
        assertThat(result.size()).isEqualTo(2);
    }

}
