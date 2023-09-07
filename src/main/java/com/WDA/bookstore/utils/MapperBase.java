package com.WDA.bookstore.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component("mapperBase")
public class MapperBase {

    private final ModelMapper modelMapper;

    @Autowired
    public MapperBase(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <S, D> D mapTo(S source, Class<D> destClass) {
        return this.modelMapper.map(source, destClass);
    }

    public <S, D> List<D> toList(List<S> source, Type destClass) {
        return this.modelMapper.map(source, destClass);
    }
}
