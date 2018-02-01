package com.tech.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column (name="EMPLOYEE_NAME")
	private String name;
	
	@Column(name = "DESIGNATION")
	private String designation;

	public Employee(int id, String name, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
}