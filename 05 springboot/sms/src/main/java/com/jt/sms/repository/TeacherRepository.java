package com.jt.sms.repository;


import com.jt.sms.model.Student;
import com.jt.sms.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
