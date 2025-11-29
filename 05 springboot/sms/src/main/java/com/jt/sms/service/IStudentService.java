package com.jt.sms.service;

import com.jt.sms.dto.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getStudents();

    StudentDTO saveStudent(StudentDTO dto);

    StudentDTO getStudent(String id);

    StudentDTO getStudentByRoll(int roll);

    StudentDTO deleteStudentById(String id);

    StudentDTO updateStudentById(String id, StudentDTO dto);

    StudentDTO partialUpdateStudentById(String id, StudentDTO dto);
}
