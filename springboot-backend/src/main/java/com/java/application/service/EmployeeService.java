package com.java.application.service;

import java.util.List;

import com.java.application.model.Employee;

public interface EmployeeService {

	// This is Used to save the Employee details
	Employee saveEmployee(Employee employee);

	// This is used to retrieve Employee details
	List<Employee> getAllEmployees();

	// This is used to retrieve Employee detail by id 
	Employee getEmployeeById(long id);

	// This is used to Update the employee details
	Employee updateEmployee(Employee employee, long id);

	// This used to delete the Employee detail by id
	void deleteEmployee(long id);
}
