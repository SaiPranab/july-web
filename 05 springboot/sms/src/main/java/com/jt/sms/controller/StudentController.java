package com.jt.sms.controller;

import com.jt.sms.dto.StudentDTO;
import com.jt.sms.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("/students")
    public List<StudentDTO> getStudents() {
        return service.getStudents();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO createStudent(@RequestBody @Valid StudentDTO dto) {
        return service.saveStudent(dto);
    }

    @GetMapping("/student/{id}")
    public StudentDTO getStudent(@PathVariable String id) {
        return service.getStudent(id);
    }

    @GetMapping("/student/roll/{roll}")
    public StudentDTO getStudentByRoll(@PathVariable int roll) {
        return service.getStudentByRoll(roll);
    }

    @DeleteMapping("/student/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentDTO deleteById(@PathVariable String id) {
        return service.deleteStudentById(id);
    }

    @PutMapping("/student/update/{id}")
    public StudentDTO updateStudent(@PathVariable String id, @RequestBody StudentDTO dto                    ){
        return service.updateStudentById(id, dto);
    }

    @PatchMapping("/student/update-by-field/{id}")
    public StudentDTO updateStudentPatch(@PathVariable String id,
                                      @RequestBody StudentDTO student) {
        return service.partialUpdateStudentById(id, student);
    }
}
