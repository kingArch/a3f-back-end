package com.a3f.building.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractMapper<T,U> {
    @Autowired
    ModelMapper modelMapper;

    TypeMap<T, U> entityToDto;
    TypeMap<U,T> dtoToEntity;

    abstract public T dtoToEntity(U dto);
    abstract public U entityToDto(T entity);
}
