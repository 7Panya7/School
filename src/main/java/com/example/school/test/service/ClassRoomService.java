package com.example.school.test.service;

import com.example.school.test.model.dto.ClassRoomDTO;

import java.util.List;

public interface ClassRoomService extends SchoolCRUD<ClassRoomDTO, Long> {
    List<ClassRoomDTO> search(String year, String code, Long teacherId);
}
