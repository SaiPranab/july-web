package com.jt.sms.controller;

import com.jt.sms.dto.StudentRequestDTO;
import com.jt.sms.model.Student;
import com.jt.sms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student newStudent) {
        return service.saveStudent(newStudent);
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {
        return service.getStudent(id);
    }

    @GetMapping("/student/roll/{roll}")
    public Student getStudentByRoll(@PathVariable int roll) {
        return service.getStudentByRoll(roll);
    }

    @DeleteMapping("/student/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student deleteById(@PathVariable String id) {
        return service.deleteStudentById(id);
    }

    @PutMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student                    ){
        return service.updateStudentById(id, student);
    }

    @PatchMapping("/student/update-by-field/{id}")
    public Student updateStudentPatch(@PathVariable String id,
                                      @RequestBody StudentRequestDTO student) {
        return service.partialUpdateStudentById(id, student);
    }
}
