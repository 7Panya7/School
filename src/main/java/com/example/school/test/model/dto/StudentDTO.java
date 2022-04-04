package com.example.school.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {

    private String name;
    private String lastName;
    private String middleName;
    private LocalDate birth;
    private String sex;
    private Boolean present;
    private Long classRoomId;
}
