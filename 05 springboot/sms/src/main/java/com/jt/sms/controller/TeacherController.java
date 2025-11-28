package com.jt.sms.controller;

import com.jt.sms.dto.StudentDTO;
import com.jt.sms.model.Teacher;
import com.jt.sms.service.StudentService;
import com.jt.sms.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService service;

    @PostMapping("/create")
    public Teacher createTeacher(@RequestBody Teacher newTeacher){
        return service.saveTeacher(newTeacher);
    }

    @PutMapping("/update/{id}")
    public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher toBeUpdated) {
        return service.updateTeacherById(id, toBeUpdated);
    }
}
