package com.java.application.controller;

import java.util.List;
/**Controller layer depends on Service layer
 * So first we will change Service layer
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.application.model.Employee;
import com.java.application.service.EmployeeService;

/**
 * @RestController is a convenient annotation that combine @Controller
 * and @ResponseBody, which eliminates the need to annotate
 * every request handling method of the controller class with
 * the @ResponseBody annotation.
 *
 */

@RestController
@RequestMapping("/api/employees") // this base employees
public class EmployeeController {

	// Constructor-based dependency injection
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	/**
	 * @RequestBody annotation allows us to request's body and
	 * automatically convert it to java object
	 */
	// build create employee REST API
	//Post ---> http://localhost:8080/api/employees
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	// build get all employees REST API
	//Get --> http://localhost:8080/api/employees
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	// build get employee by id REST API
	// Get --> http://localhost:8080/api/employees/1
	// 1 is dynamic value u can pass the any id value 
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}

	// build update employee REST API
	// Put --> http://localhost:8080/api/employees/1
	// 1 is dynamic value u can pass the any id value 
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}
	
	
	// build delete employee REST API
	// Delete --> http://localhost:8080/api/employees/1
	// 1 is dynamic value u can pass the any id value 
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

		// delete employee from DB
		employeeService.deleteEmployee(id);

		return new ResponseEntity<String>("Employee delete successfully", HttpStatus.OK);
	}

}
