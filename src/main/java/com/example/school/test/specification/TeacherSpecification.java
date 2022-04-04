package com.example.school.test.specification;

import com.example.school.test.model.entity.Student;
import com.example.school.test.model.entity.Teacher;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class TeacherSpecification {
    public static Specification<Teacher> getSpecification(String name, String lastName, String middleName,
                                                          LocalDate birth, String sex, String subject) {
        Specification<Teacher> spec = null;
        Specification<Teacher> temp = null;

        if (name != null) {
            spec = getTeacherByName(name);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        if (lastName != null) {
            spec = getTeacherByLastName(lastName);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        if (middleName != null) {
            spec = getTeacherByMiddleNane(middleName);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        if (birth != null) {
            spec = getTeacherByBirth(birth);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        if (sex != null) {
            spec = getTeacherBySex(sex);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        if (subject != null) {
            spec = getTeacherBySubject(subject);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        return spec;
    }

    private static Specification<Teacher> getTeacherBySubject(String subject) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("subject"), "%" + subject + "%");
        };
    }

    private static Specification<Teacher> getTeacherBySex(String sex) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("sex"),"%" + sex + "%");
        };
    }

    private static Specification<Teacher> getTeacherByBirth(LocalDate birth) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("birth"),birth);
        };
    }

    private static Specification<Teacher> getTeacherByMiddleNane(String middleName) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("middleName"),"%" + middleName + "%");
        };
    }

    private static Specification<Teacher> getTeacherByLastName(String lastName) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("lastName"),"%" + lastName + "%");
        };
    }

    private static Specification<Teacher> getTeacherByName(String name) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("name"),"%" + name + "%");
        };
    }
}
