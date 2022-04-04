package com.example.school.test.mapper.impl;

import com.example.school.test.mapper.Mapper;
import com.example.school.test.model.dto.ClassRoomDTO;
import com.example.school.test.model.entity.ClassRoom;
import com.example.school.test.model.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class ClassRoomMapper implements Mapper<ClassRoom, ClassRoomDTO> {

    @Override
    public ClassRoom toEntity(ClassRoomDTO classRoomDTO) {
        ClassRoom classRoom = new ClassRoom();
        Teacher teacher = new Teacher();
        teacher.setId(classRoomDTO.getTeacherId());

        classRoom.setYear(classRoomDTO.getYear());
        classRoom.setCode(classRoomDTO.getCode());
        classRoom.setTeacherId(teacher);
        return classRoom;
    }

    @Override
    public ClassRoomDTO toDTO(ClassRoom classRoom) {
        return ClassRoomDTO.builder()
                .year(classRoom.getYear())
                .code(classRoom.getCode())
                .teacherId(classRoom.getTeacherId().getId())
                .build();
    }
}
