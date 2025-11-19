package com.example.jpa_annotation_concept;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
  
}
