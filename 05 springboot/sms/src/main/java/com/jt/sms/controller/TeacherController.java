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
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
@Slf4j
public class TeacherController {
    private final TeacherService service;
//    private Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @PostMapping("/create")
    public Teacher createTeacher(@RequestBody Teacher newTeacher){
//        logger.trace("TRACE -> Saving teacher " + newTeacher);
//        logger.debug("DEBUG -> Saving teacher " + newTeacher);
//        logger.info("INFO -> Saving teacher " + newTeacher);
//        logger.warn("WARN -> Saving teacher " + newTeacher);
//        logger.error("ERROR -> Saving teacher " + newTeacher);

        log.trace("TRACE -> Saving1 teacher " + newTeacher);
        log.debug("DEBUG -> Saving1 teacher " + newTeacher);
        log.info("INFO -> Saving1 teacher " + newTeacher);
        log.warn("WARN -> Saving1 teacher " + newTeacher);
        log.error("ERROR -> Saving1 teacher " + newTeacher);
        return service.saveTeacher(newTeacher);
    }

    @PutMapping("/update/{id}")
    public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher toBeUpdated) {
        return service.updateTeacherById(id, toBeUpdated);
    }
}

/**
 *  TRACE -> TRACE, DEBUG, INFO, WARN, ERROR
 *  DEBUG -> DEBUG, INFO, WARN, ERROR
 *  INFO(default) -> INFO, WARN, ERROR
 *  WARN -> WARN, ERROR
 *  ERROR -> ERROR
 */