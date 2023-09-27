package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	@Autowired
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			List<Student> studentList = List.of(
					new Student(null, "PeaNu", 20, "peanu@peanu.dev", LocalDate.of(1998, Month.JUNE, 29)),
					new Student(null, "Britz", 25, "britz@peanu.dev", LocalDate.of(1988, Month.JUNE, 21)),
					new Student(null, "Joe", 29, "joe@peanu.dev", LocalDate.of(1978, Month.APRIL, 11)),
					new Student(null, "Allie", 23, "allie@peanu.dev", LocalDate.of(2000, Month.JUNE, 10)),
					new Student(null, "Vanna", 18, "vanna@peanu.dev", LocalDate.of(2001, Month.APRIL, 5))
			);

			studentRepository.saveAll(studentList);
		};
	}

}
