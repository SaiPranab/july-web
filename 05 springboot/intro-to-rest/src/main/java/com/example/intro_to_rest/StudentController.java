package com.example.intro_to_rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

// @Controller
// @ResponseBody
@RestController
@RequiredArgsConstructor
public class StudentController {
  private final ObjectMapper mapper;
  
  @GetMapping("/student")
  // @ResponseBody // - It tells Spring Container to actually return a json object instead of html file name
  public Student getStudent() {
    return new Student(101, "Sai");
  }

  @GetMapping("/student2")
  public void getStudent2() throws JsonProcessingException {
    Student student = new Student(102, "Bhabgrahi");
    
    String json = mapper.writeValueAsString(student);
    System.out.println("/////////////////////  -> " + json);


    Student studentFromJson = mapper.readValue(json, Student.class);
    System.out.println("..................... -> " + studentFromJson);
  }

  @GetMapping("/student3")
  // @ResponseBody 
  public Student getStudent3() {
    return new Student(103, "Ankit ");
  }

}