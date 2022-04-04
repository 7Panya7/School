package com.example.school.test.service;

import com.example.school.test.model.dto.StudentDTO;
import com.example.school.test.model.entity.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService extends SchoolCRUD<StudentDTO, Long> {
    List<StudentDTO> search(String name, String lastName, String middleNam,
                         LocalDate birth, String sex, Long classRoomId);
}
