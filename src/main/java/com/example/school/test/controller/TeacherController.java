package com.example.school.test.controller;

import com.example.school.test.model.dto.TeacherDTO;
import com.example.school.test.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService service;

    @PostMapping
    public ResponseEntity<TeacherDTO> save(@RequestBody TeacherDTO teacherDTO) {
        return ResponseEntity.ok(service.create(teacherDTO));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TeacherDTO>> getAllByFilter(@RequestParam(required = false) String name,
                                                           @RequestParam(required = false) String lastName,
                                                           @RequestParam(required = false) String middleName,
                                                           @RequestParam(required = false) LocalDate birth,
                                                           @RequestParam(required = false) String sex,
                                                           @RequestParam(required = false) String subject) {
        return ResponseEntity.ok(service.search(name,lastName,middleName,birth,sex,subject));
    }

    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
