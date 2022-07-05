package com.java.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.application.model.Employee;


/**
 *Spring Data JPA internally provides @Repository
 *Annotation so we need to add @Repository
 *annotation to EmployeeRepository interface  
 */ 

/**
 * By default Spring Data JPA made JpaRepository 
 * methods transactional So we no need to add 
 * @Transactional annotation in Service class
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
}
