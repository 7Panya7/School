package com.example.school.test.repository;

import com.example.school.test.model.entity.ClassRoom;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    List<ClassRoom> findAll(Specification<ClassRoom> specification);
}
