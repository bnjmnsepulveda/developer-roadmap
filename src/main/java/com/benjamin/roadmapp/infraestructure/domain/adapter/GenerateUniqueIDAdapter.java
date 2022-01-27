package com.benjamin.roadmapp.infraestructure.domain.adapter;

import com.benjamin.roadmapp.domain.ports.outgoing.GenerateUniqueID;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenerateUniqueIDAdapter implements GenerateUniqueID {
    @Override
    public String handle() {
        return UUID.randomUUID().toString();
    }
}
