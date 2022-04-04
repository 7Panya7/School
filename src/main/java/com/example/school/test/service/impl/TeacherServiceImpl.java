package com.example.school.test.service.impl;

import com.example.school.test.mapper.impl.TeacherMapper;
import com.example.school.test.model.dto.TeacherDTO;
import com.example.school.test.model.entity.Teacher;
import com.example.school.test.repository.TeacherRepository;
import com.example.school.test.service.TeacherService;
import com.example.school.test.specification.TeacherSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository repository;
    private final TeacherMapper mapper;

    @Transactional
    @Override
    public TeacherDTO create(TeacherDTO teacherDTO) {
        return mapper.toDTO(repository.save(mapper.toEntity(teacherDTO)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<TeacherDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<TeacherDTO> search(String name, String lastName, String middleName,
                                   LocalDate birth, String sex, String subject) {

        Specification<Teacher> specification = TeacherSpecification.getSpecification(name,lastName,middleName,
                birth,sex,subject);
        return repository.findAll(specification).stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
