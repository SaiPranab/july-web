package com.example.many_to_one;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class ManyToOneApplication {
	private final SubjectRepository subjectRepository;
	private final TeacherRepository teacherRepository;

	public static void main(String[] args) {
		SpringApplication.run(ManyToOneApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			// var sub1 = Subject.builder().subjectName("C").build();
			// var sub2 = Subject.builder().subjectName("C++").build();
			// var sub3 = Subject.builder().subjectName("Java").build();
			// var sub4 = Subject.builder().subjectName("Python").build();
			// var sub5 = Subject.builder().subjectName("Javascript").build();
			// var sub6 = Subject.builder().subjectName(".NET").build();

			// var teacher1 = Teacher.builder().teacherName("Rashmi Sir").build();
			// var teacher2 = Teacher.builder().teacherName("Koushik Sir").build();
			// var teacher3 = Teacher.builder().teacherName("Abinash Sir").build();

			// sub1.setTeacher(teacher1);
			// sub2.setTeacher(teacher1);
			// sub3.setTeacher(teacher2);
			// sub4.setTeacher(teacher2);
			// sub5.setTeacher(teacher3);
			// sub6.setTeacher(teacher3);
			// subjectRepository.saveAll(List.of(sub1, sub2, sub3, sub4, sub5, sub6));

			// var existingSubject = subjectRepository.findById(7).orElseThrow();
			// existingSubject.setSubjectName("C");
			// existingSubject.getTeacher().setTeacherName("Rashmi Sir");

			// // teacherRepository.save(existingSubject.getTeacher());
			// subjectRepository.save(existingSubject);

			// // var existingSubject = subjectRepository.findById(8).orElseThrow();
			// // subjectRepository.deleteById(existingSubject.getSubjectId());
			// // teacherRepository.deleteById(existingSubject.getTeacher().getTeacherId());
			// var existingSubject1 = subjectRepository.findById(9).orElseThrow();
			// subjectRepository.deleteAll(List.of(existingSubject1));

			// =================== Bi-directional mapping =====================
			var sub1 = Subject.builder().subjectName("C").build();
			var sub2 = Subject.builder().subjectName("C++").build();
			var sub3 = Subject.builder().subjectName("Java").build();
			var sub4 = Subject.builder().subjectName("Python").build();
			var sub5 = Subject.builder().subjectName("Javascript").build();
			var sub6 = Subject.builder().subjectName(".NET").build();

			var teacher1 = new Teacher();
			teacher1.setTeacherName("Rashmi Sir");
			var subjectsForTeacher1 = teacher1.getSubjects();
			subjectsForTeacher1.add(sub1);
			subjectsForTeacher1.add(sub2);
			teacher1.setSubjects(subjectsForTeacher1);

			sub1.setTeacher(teacher1);
			sub2.setTeacher(teacher1);
			teacherRepository.save(teacher1);
		};
	}
}
