package com.example.one_to_one;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class OneToOneApplication {
	private final StudentRepository studentRepository;
	private final AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			// var address = Address.builder()
			// 							.city("BBSR")
			// 							.state("Odisha")
			// 							.country("IN")
			// 							.build();

			// var student = Student.builder()
			// 							.studentName("Bishal")
			// 							.studentEmail("b@gmail.com")
			// 							.address(address)
			// 							.build();

			// 	// addressRepository.save(address);
			// 	studentRepository.save(student);



			// var existingStudent = studentRepository.findById(3).orElseThrow();
			// existingStudent.setStudentName("Viswanath sahu");
			// existingStudent.getAddress().setCity("BBSR");
			// studentRepository.save(existingStudent);



			// studentRepository.deleteById(2);



			// var existingStudent = studentRepository.findById(1).orElseThrow();
			// System.out.println(existingStudent.getStudentRoll());
			// System.out.println(existingStudent.getStudentName());
			// System.out.println(existingStudent.getStudentEmail());

			// var existingAddress = existingStudent.getAddress();
			// System.out.println(existingAddress.getCity());
			// System.out.println(existingAddress.getState());
			// System.out.println(existingAddress.getCountry());






			// var student = Student.builder()
			// 								.studentName("Bishal")
			// 								.studentEmail("b@gmail.com")
			// 								.build();

			// var address = Address.builder()
			// 									.city("BBSR")
			// 									.state("Odisha")
			// 									.country("IN")
			// 									.student(student)
			// 									.build();
			// addressRepository.save(address);
							
			// var address = Address.builder()
			// 									.city("CTC")
			// 									.state("Odisha")
			// 									.country("IN")
			// 									.build();

			// var student = Student.builder()
			// 								.studentName("Bhabagrahi")
			// 								.studentEmail("bhabagrahi@gmail.com")
			// 								.address(address)
			// 								.build();
			// studentRepository.save(student);


			// var existingAddress = addressRepository.findById("c466ab99-6229-4f3b-9c5e-fbae04b2888a").orElseThrow();
			// System.out.println(existingAddress.getCity());
			// System.out.println(existingAddress.getState());
			// System.out.println(existingAddress.getCountry());

			// var existingStudent = existingAddress.getStudent();
			// System.out.println(existingStudent.getStudentRoll());
			// System.out.println(existingStudent.getStudentName());
			// System.out.println(existingStudent.getStudentEmail());



			addressRepository.deleteById("c466ab99-6229-4f3b-9c5e-fbae04b2888a");
		};
	}
}
