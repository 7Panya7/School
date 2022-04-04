package com.example.school.test.specification;

import com.example.school.test.model.entity.ClassRoom;
import org.springframework.data.jpa.domain.Specification;

public class ClassRoomSpecification {
    public static Specification<ClassRoom> getSpecification(String year, String code, Long teacherId) {
        Specification<ClassRoom> spec = null;
        Specification<ClassRoom> temp = null;

        if (year != null) {
            spec = getClassRoomByYear(year);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        if (code != null) {
            spec = getClassRoomByCode(code);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        if (teacherId != null) {
            spec = getClassRoomByTeacherId(teacherId);
            temp = spec != null?Specification.where(spec).and(temp):temp;
        }
        return spec;
    }

    private static Specification<ClassRoom> getClassRoomByTeacherId(Long teacherId) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("teacherId"), teacherId);
        };
    }

    private static Specification<ClassRoom> getClassRoomByCode(String code) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("code"),"%" + code + "%");
        };
    }

    private static Specification<ClassRoom> getClassRoomByYear(String year) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get("year"),"%" + year + "%");
        };
    }
}
