package com.jt.sms.service;

import com.jt.sms.dto.StudentRequestDTO;
import com.jt.sms.model.Student;
import com.jt.sms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student saveStudent(Student newStudent) {
        return repository.save(newStudent);
    }

    public Student getStudent(String id) {
        return repository.findById(id).orElseThrow();
    }

    public Student getStudentByRoll(int roll) {
        return repository.findByRoll(roll).orElseThrow();
    }

    public Student deleteStudentById(String id) {
        Student existingStudent = getStudent(id);
        repository.delete(existingStudent);
        return existingStudent;
    }

    public Student updateStudentById(String id, Student updatedStudent) {
        getStudent(id);
        updatedStudent.setId(id);
        return repository.save(updatedStudent);
    }

    public Student partialUpdateStudentById(String id, StudentRequestDTO updatedStudent) {
        System.out.println(updatedStudent);
        Student existingStudent = getStudent(id);

        if(updatedStudent.getRoll() != null) existingStudent.setRoll(updatedStudent.getRoll());
        if(updatedStudent.getName() != null) existingStudent.setName(updatedStudent.getName());
        if(updatedStudent.getEmail() != null) existingStudent.setEmail(updatedStudent.getEmail());
        if(updatedStudent.getFee() != null) existingStudent.setFee(updatedStudent.getFee());
        if(updatedStudent.getPhoneNumber() != null) existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());

        return repository.save(existingStudent);
    }
}
