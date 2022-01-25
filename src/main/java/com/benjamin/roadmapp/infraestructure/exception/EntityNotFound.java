package com.benjamin.roadmapp.infraestructure.exception;

import com.benjamin.roadmapp.domain.entity.RoadMap;

public class EntityNotFound extends RuntimeException{
    public EntityNotFound(String message) {
        super(message);
    }

    public EntityNotFound(String message, Throwable cause) {
        super(message, cause);
    }

}
