package com.javabase.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javabase.application.entity.Student;
import com.javabase.application.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemUsingSpringBootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemUsingSpringBootApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		/*
		 * Student student1 = new Student("Balji", "Balu", "balubalaji@gmail.com");
		 * studentRepository.save(student1);
		 * 
		 * Student student2 = new Student("Abi", "Ram", "abiram12@gmail.com");
		 * studentRepository.save(student2);
		 * 
		 * Student student3 = new Student("Rajesh", "Raja", "rajeshraja92@gmail.com");
		 * studentRepository.save(student3);
		 */
		
	}

}
