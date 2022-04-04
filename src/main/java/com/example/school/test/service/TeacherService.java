package com.example.school.test.service;

import com.example.school.test.model.dto.TeacherDTO;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface TeacherService extends SchoolCRUD<TeacherDTO, Long> {
    List<TeacherDTO> search(String name, String lastName, String middleName,
                            LocalDate birth, String sex, String subject);
}
