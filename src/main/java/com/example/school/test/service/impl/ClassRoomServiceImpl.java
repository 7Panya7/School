package com.example.school.test.service.impl;

import com.example.school.test.mapper.impl.ClassRoomMapper;
import com.example.school.test.model.dto.ClassRoomDTO;
import com.example.school.test.model.entity.ClassRoom;
import com.example.school.test.repository.ClassRoomRepository;
import com.example.school.test.service.ClassRoomService;
import com.example.school.test.specification.ClassRoomSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClassRoomServiceImpl implements ClassRoomService {
    private final ClassRoomRepository repository;
    private final ClassRoomMapper mapper;

    @Transactional
    @Override
    public ClassRoomDTO create(ClassRoomDTO classRoomDTO) {
        return mapper.toDTO(repository.save(mapper.toEntity(classRoomDTO)));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClassRoomDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClassRoomDTO> search(String year, String code, Long teacherId) {

        Specification<ClassRoom> specification = ClassRoomSpecification.getSpecification(year,code,teacherId);
        return repository.findAll(specification).stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
