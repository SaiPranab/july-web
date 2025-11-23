package com.jt.sms.service;

import com.jt.sms.dto.StudentDTO;
import com.jt.sms.exception.StudentNotFoundException;
import com.jt.sms.mapper.StudentMapper;
import com.jt.sms.model.Student;
import com.jt.sms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<StudentDTO> getStudents() {
        List<StudentDTO> studentDTOS = repository.findAll()
                .stream()
//                .map(student -> StudentMapper.convertStudentToStudentDTO(student))
                .map(StudentMapper :: convertStudentToStudentDTO)
                .toList();

        return studentDTOS;
    }

    public StudentDTO saveStudent(StudentDTO dto){
        Student newStudent = StudentMapper.convertStudentDTOToStudent(dto);
        Student savedStudent = repository.save(newStudent);

        return StudentMapper.convertStudentToStudentDTO(savedStudent);
    }

    public StudentDTO getStudent(String id) {
        Student existingStudent = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found With id " + id));

        return StudentMapper.convertStudentToStudentDTO(existingStudent);
    }

    public StudentDTO getStudentByRoll(int roll) {
//        try {
//            return repository.findByRoll(roll).orElseThrow();
//        } catch (NoSuchElementException e) {
//            System.out.println("Student Not Found");
//            return null;
//        }

        Student existingStudent = repository.findByRoll(roll)
                .orElseThrow(() -> new StudentNotFoundException("Student Not Found with roll " + roll));

        return StudentMapper.convertStudentToStudentDTO(existingStudent);
    }

    public StudentDTO deleteStudentById(String id) {
        StudentDTO existingStudentDTO = getStudent(id);
        repository.deleteById(id);
        return existingStudentDTO;
    }

    public StudentDTO updateStudentById(String id, StudentDTO dto) {
        getStudent(id);

        Student toBeUpdated = StudentMapper.convertStudentDTOToStudent(dto);
        toBeUpdated.setId(id);
        Student updatedStudent = repository.save(toBeUpdated);

        return StudentMapper.convertStudentToStudentDTO(updatedStudent);
    }

    public StudentDTO partialUpdateStudentById(String id, StudentDTO dto) {
        StudentDTO existingStudentDTO = getStudent(id);
        Student existingStudent = StudentMapper.convertStudentDTOToStudent(dto);
        existingStudent.setId(id);

        if(dto.getRoll() != null) existingStudent.setRoll(dto.getRoll());
        if(dto.getName() != null) existingStudent.setName(dto.getName());
        if(dto.getEmail() != null) existingStudent.setEmail(dto.getEmail());
        if(dto.getFee() != null) existingStudent.setFee(dto.getFee());
        if(dto.getPhoneNumber() != null) existingStudent.setPhoneNumber(dto.getPhoneNumber());

        Student updatedStudent = repository.save(existingStudent);
        return StudentMapper.convertStudentToStudentDTO(updatedStudent);
    }
}
