package com.jt.sms.mapper;

import com.jt.sms.dto.StudentDTO;
import com.jt.sms.model.Student;
import org.springframework.beans.BeanUtils;

public class StudentMapper {
    private StudentMapper() {}

    public static Student convertStudentDTOToStudent(StudentDTO dto) {
        Student student = new Student();
        BeanUtils.copyProperties(dto, student);

        return student;
    }

    public static StudentDTO convertStudentToStudentDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        BeanUtils.copyProperties(student, dto);

        return dto;
    }
}
