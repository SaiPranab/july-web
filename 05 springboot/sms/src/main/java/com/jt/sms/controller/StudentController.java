package com.jt.sms.controller;

import com.jt.sms.dto.StudentDTO;
import com.jt.sms.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Student API",
    description = "This controller manages CRUD operation for Students"
)
public class StudentController {
    private final StudentService service;

    @Operation(summary = "Get All Students", description = "Fetch All Students")
    @GetMapping("/students")
    public List<StudentDTO> getStudents() {
        return service.getStudents();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a new Student")
    @ApiResponse(description = "Student vaidation failed", responseCode = "422")
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
