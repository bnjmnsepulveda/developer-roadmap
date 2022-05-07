package com.benjamin.roadmapp.infraestructure.config;

import com.benjamin.roadmapp.domain.ports.outgoing.KnowledgeRepository;
import com.benjamin.roadmapp.domain.ports.outgoing.LanguageRepository;
import com.benjamin.roadmapp.domain.ports.outgoing.RoadMapRepository;
import com.benjamin.roadmapp.domain.service.KnowledgeService;
import com.benjamin.roadmapp.domain.service.LanguageService;
import com.benjamin.roadmapp.domain.service.RoadMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainBeanConfig {

    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private KnowledgeRepository knowledgeRepository;
    @Autowired
    private RoadMapRepository roadMapRepository;

    @Bean
    public LanguageService getLanguageService() {
        return new LanguageService(languageRepository);
    }
    @Bean
    public KnowledgeService getKnowledgeService(){
        return new KnowledgeService(knowledgeRepository);
    }
    @Bean
    public RoadMapService getRoadMapService() {
        return new RoadMapService(roadMapRepository);
    }

}
