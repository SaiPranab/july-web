package com.example.many_to_one;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Teacher {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int teacherId;

  private String teacherName;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", fetch = FetchType.EAGER)
  private List<Subject> subjects = new ArrayList<>();
}
