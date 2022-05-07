package com.benjamin.roadmapp.domain.ports.incoming;

import java.util.List;

public interface DomainService<T> {

    T create(T entity);
    T findById(String id);
    List<T> findAll();

}
