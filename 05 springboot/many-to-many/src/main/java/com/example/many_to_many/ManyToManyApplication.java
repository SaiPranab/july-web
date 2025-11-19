package com.example.many_to_many;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToManyApplication {
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			// Course course1 = Course.builder().courseName("C").build();
			// Course course2 = Course.builder().courseName("C++").build();
			// Course course3 = Course.builder().courseName("Java").build();
			// Course course4 = Course.builder().courseName("Python").build();

			// Student student1 = Student.builder()
			// .studentName("Biswa")
			// .courses(List.of(course1, course2))
			// .build();

			// Student student2 = Student.builder()
			// .studentName("Amiya")
			// .courses(List.of(course2, course3))
			// .build();

			// Student student3 = Student.builder()
			// .studentName("Ankit")
			// .courses(List.of(course3, course4))
			// .build();

			// studentRepository.saveAll(List.of(student1, student2, student3));

			// Student existingStudent = studentRepository.findById(4).orElseThrow();
			// existingStudent.setStudentName("Biswa 12");
			// List<Course> courses = existingStudent.getCourses();
			// List<Course> updatedCourses = courses.stream().map(course -> {
			// 	course.setCourseName(course.getCourseName() + " 1");
			// 	return course;
			// }).toList();
			// existingStudent.setCourses(updatedCourses);

			// // courseRepository.saveAll(updatedCourses);
			// studentRepository.save(existingStudent);





			// ============================== BI - DIRECTIONAL ======================
			Course course = courseRepository.findById(2).orElseThrow();
			System.out.println(course.getCourseId());
			System.out.println(course.getCourseName());

			List<Student> students = course.getStudents();
			students.forEach(s -> {
				System.out.println(s.getStudentId() + " -> " + s.getStudentName());
			});
		};
	}
}
