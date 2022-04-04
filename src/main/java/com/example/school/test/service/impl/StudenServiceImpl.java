package com.example.school.test.service.impl;

import com.example.school.test.mapper.impl.StudentMapper;
import com.example.school.test.model.dto.StudentDTO;
import com.example.school.test.model.entity.Student;
import com.example.school.test.repository.StudentRepository;
import com.example.school.test.service.StudentService;
import com.example.school.test.specification.StudentSpecification;
import com.example.school.test.specification.TeacherSpecification;
import lombok.RequiredArgsConstructor;
import org.hibernate.Transaction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudenServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Transactional
    @Override

    public StudentDTO create(StudentDTO studentDTO) {
        return mapper.toDTO(repository.save(mapper.toEntity(studentDTO)));
    }

    @Transactional
    @Override
    public List<StudentDTO> getAll() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentDTO> search(String name, String lastName, String middleName,
                                LocalDate birth, String sex, Long classRoomId) {

        Specification<Student> specification = StudentSpecification.getSpecification(name,lastName,middleName,
                birth,sex, classRoomId);
        return repository.findAll(specification).stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
