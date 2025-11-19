package com.example.jpa_annotation_concept;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "emp")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "emp_id")
  private String employeeId;

  @Column(name = "emp_name", columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
  private String employeeName;

  @Lob // String -> LONGTEXT, byte[] -> LONG BLOB, char[] -> LONG TEXT
  private String employeeDescription;

  @Column(precision = 10, scale = 2)
  private BigDecimal employeeSalary;

  @Enumerated(EnumType.STRING)
  private EmployeeStatus employeeStatus;

  @CreationTimestamp
  public LocalDateTime createdTime;

  @UpdateTimestamp
  public LocalDateTime updatedTime;
}
