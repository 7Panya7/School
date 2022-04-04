package com.example.school.test.service;

import java.util.List;

public interface SchoolCRUD <T, ID>{
    T create(T t);
    List<T> getAll();
    void deleteById(ID id);
}
