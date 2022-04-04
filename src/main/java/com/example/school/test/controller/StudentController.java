package com.example.school.test.controller;

import com.example.school.test.model.dto.StudentDTO;
import com.example.school.test.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    @PostMapping
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.ok(service.create(studentDTO));
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAllByFilter(@RequestParam(required = false) String name,
                                                           @RequestParam(required = false) String lastName,
                                                           @RequestParam(required = false) String middleName,
                                                           @RequestParam(required = false) LocalDate birth,
                                                           @RequestParam(required = false) String sex,
                                                           @RequestParam(required = false)Long classRoomId) {
        return ResponseEntity.ok(service.search(name, lastName, middleName, birth, sex, classRoomId));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
