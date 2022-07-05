package com.java.application.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.application.exception.ResourceNotFoundException;
import com.java.application.model.Employee;
import com.java.application.repository.EmployeeRepository;
import com.java.application.service.EmployeeService;

/**
 * 2 types 1. Setter-based dependency injection
 * 
 * 2. Constructor-based dependency injection
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	// Constructor-based dependency injection
	private EmployeeRepository employeeRepository;

	/**
	 * Starting with spring 4.3, if a class, which is configured as a spring bean,
	 * has only one constructor, the @Autowired annotation can be omitted and spring
	 * will use constructor and inject all necessary dependencies.
	 * 
	 */
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// This is Normal Way
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}

		// This is lambda expression Way
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());

		// save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

		employeeRepository.deleteById(id);
	}
}