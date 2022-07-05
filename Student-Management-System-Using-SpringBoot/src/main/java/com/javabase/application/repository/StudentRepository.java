package com.javabase.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabase.application.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
