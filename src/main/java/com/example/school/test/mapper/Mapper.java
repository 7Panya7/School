package com.example.school.test.mapper;

public interface Mapper<T,DTO> {
    T toEntity(DTO dto);
    DTO toDTO(T t);
}