package com.jt.sms.service;

import com.jt.sms.model.Teacher;
import com.jt.sms.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository repository;

    public Teacher saveTeacher(Teacher newTeacher) {
        return repository.save(newTeacher);
    }

    public Teacher updateTeacherById(int id, Teacher toBeUpdatedTeacher) {
        getTeacherById(id);

        toBeUpdatedTeacher.setTeacherId(id);
        return repository.save(toBeUpdatedTeacher);
    }

    private Teacher getTeacherById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Teacher not found with id" + id));
    }
}
