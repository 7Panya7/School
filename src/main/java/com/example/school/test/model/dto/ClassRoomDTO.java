package com.example.school.test.model.dto;

import com.example.school.test.model.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassRoomDTO {

    private String year;
    private String code;
    private Long teacherId;
}
