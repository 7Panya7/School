package com.example.school.test.controller;

import com.example.school.test.model.dto.ClassRoomDTO;
import com.example.school.test.service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/class-room")
@RequiredArgsConstructor
public class ClassRoomControler {
    private final ClassRoomService service;

    @PostMapping
    public ResponseEntity<ClassRoomDTO> save(@RequestBody ClassRoomDTO classRoomDTO){
        return ResponseEntity.ok(service.create(classRoomDTO));
    }

    @GetMapping
    public ResponseEntity<List<ClassRoomDTO>> findAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ClassRoomDTO>> findAllByFilter(@RequestParam(required = false) String year,
                                                              @RequestParam(required = false) String code,
                                                              @RequestParam(required = false) Long teacherId) {
        return ResponseEntity.ok(service.search(year, code, teacherId));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
