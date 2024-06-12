package com.example.Task1.mapper;

import com.example.Task1.dto.AllMethodsDto;
import com.example.Task1.entity.Method;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AllMethodsDtoMapper {
    AllMethodsDto allMethodsToDto(Method allMethodsList);
}
