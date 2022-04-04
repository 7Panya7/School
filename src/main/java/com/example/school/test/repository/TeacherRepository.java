package com.example.school.test.repository;

import com.example.school.test.model.entity.Student;
import com.example.school.test.model.entity.Teacher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAll(Specification<Teacher> specification);
}
