package com.example.jpa_annotation_concept;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaAnnotationConceptApplication {
	private final EmployeeRepository employeeRepository;


	public static void main(String[] args) {
		SpringApplication.run(JpaAnnotationConceptApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		CommandLineRunner runner = new CommandLineRunner() {
			@Override
			public void run(String ...args) {
				// Employee employee = Employee.builder()
				// 										.employeeName("Rudranarayan Padhi")
				// 										.employeeSalary(BigDecimal.valueOf(90000.99))
				// 										.employeeDescription("Rudra is a very good employee")
				// 										.build();

				// employeeRepository.save(employee);


				Employee existingEmployee = employeeRepository
														.findById("fa5a3492-2016-4af4-863e-6a2e1450b2fc").orElseThrow();

				System.out.println("////////////////" + existingEmployee);
				existingEmployee.setEmployeeStatus(EmployeeStatus.ACTIVE);
				employeeRepository.save(existingEmployee);
			}
		};

		return runner;
	}
}
