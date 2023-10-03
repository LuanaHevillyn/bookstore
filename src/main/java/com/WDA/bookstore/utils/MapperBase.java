package com.WDA.bookstore.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
        return modelMapper.map(source, destClass);
    }

    public <S, D> List<D> toList(List<S> source, Type destClass) {
        return modelMapper.map(source, destClass);
    }

    public <S, D> Page<D> toPage(Page<S> source, Type dest) {
        List<D> list = toList(source.getContent(), dest);
        return new PageImpl<>(list, source.getPageable(), source.getTotalElements());
    }
}
