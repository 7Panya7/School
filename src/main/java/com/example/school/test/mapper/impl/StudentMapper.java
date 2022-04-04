package com.example.school.test.mapper.impl;

import com.example.school.test.mapper.Mapper;
import com.example.school.test.model.dto.StudentDTO;
import com.example.school.test.model.entity.ClassRoom;
import com.example.school.test.model.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements Mapper<Student, StudentDTO> {
    @Override
    public Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(studentDTO.getClassRoomId());
        student.setName(studentDTO.getName());
        student.setLastName(studentDTO.getLastName());
        student.setMiddleName(studentDTO.getMiddleName());
        student.setBirth(studentDTO.getBirth());
        student.setSex(studentDTO.getSex());
        student.setClassRoomId(classRoom);
        return student;
    }

    @Override
    public StudentDTO toDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setMiddleName(student.getMiddleName());
        studentDTO.setBirth(student.getBirth());
        studentDTO.setSex(student.getSex());
        studentDTO.setClassRoomId(student.getClassRoomId().getId());
        return studentDTO;
    }
}
