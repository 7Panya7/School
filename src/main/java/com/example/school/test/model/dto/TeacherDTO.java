package com.example.school.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDTO {

    private String name;
    private String lastName;
    private String middlename;
    private LocalDate birth;
    private String sex;
    private String subject;
}
