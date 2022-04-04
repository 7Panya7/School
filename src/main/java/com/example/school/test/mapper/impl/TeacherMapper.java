package com.example.school.test.mapper.impl;

import com.example.school.test.mapper.Mapper;
import com.example.school.test.model.dto.TeacherDTO;
import com.example.school.test.model.entity.Student;
import com.example.school.test.model.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper implements Mapper<Teacher, TeacherDTO> {

    @Override
    public Teacher toEntity(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherDTO.getName());
        teacher.setLastName(teacherDTO.getLastName());
        teacher.setMiddleName(teacherDTO.getMiddlename());
        teacher.setBirth(teacherDTO.getBirth());
        teacher.setSubject(teacherDTO.getSubject());
        teacher.setSex(teacherDTO.getSex());
        return teacher;
    }

    @Override
    public TeacherDTO toDTO(Teacher teacher) {
        return TeacherDTO.builder()
                .name(teacher.getName())
                .lastName(teacher.getLastName())
                .middlename(teacher.getMiddleName())
                .birth(teacher.getBirth())
                .subject(teacher.getSubject())
                .sex(teacher.getSex())
                .build();
    }
}
