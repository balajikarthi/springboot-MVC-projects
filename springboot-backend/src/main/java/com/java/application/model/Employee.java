package com.java.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

// I'm Using Lombok, 
// it is used to handle Getter, Setter,
//RequiredArgsConstructor, ToString, EqualsAndHashCode.
@Data
@Entity  //JPA annotation
@Table(name = "employees")
public class Employee {
	
	@Id  // To generate primary key in a table
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="first_name", nullable = false)
	private String firstName;
	
	@Column(name ="last_name")
	private String lastName;
	
	@Column(name ="email")
	private String email;

}
