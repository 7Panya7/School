package com.example.school.test.specification;

import com.example.school.test.model.entity.Student;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class StudentSpecification {
    public static Specification<Student> getSpecification(String name, String lastName, String middleName,
                                                             LocalDate birth, String sex, Long classRoomId) {
        Specification<Student> spec = null;
        Specification<Student> temp = null;

        if (name != null) {
            spec = getStudentByName(name);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        if (lastName != null) {
            spec = getStudentByLastName(lastName);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        if (middleName != null) {
            spec = getStudentByMiddleNane(middleName);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        if (birth != null) {
            spec = getStudentByBirth(birth);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        if (sex != null) {
            spec = getStudentBySex(sex);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        if (classRoomId != null) {
            spec = getStudentByClassRoomId(classRoomId);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        return spec;
    }

    private static Specification<Student> getStudentByClassRoomId(Long classRoomId) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("classRoomId"), classRoomId);
        };
    }

    private static Specification<Student> getStudentBySex(String sex) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("sex"),"%" + sex + "%");
        };
    }

    private static Specification<Student> getStudentByBirth(LocalDate birth) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("birth"),birth);
        };
    }

    private static Specification<Student> getStudentByMiddleNane(String middleName) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("middleName"),"%" + middleName + "%");
        };
    }

    private static Specification<Student> getStudentByLastName(String lastName) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("lastName"),"%" + lastName + "%");
        };
    }

    private static Specification<Student> getStudentByName(String name) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("name"),"%" + name + "%");
        };
    }
}
