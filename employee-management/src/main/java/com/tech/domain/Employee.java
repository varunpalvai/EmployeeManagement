package com.tech.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name = "EMPLOYEE_ID")
	private Long employeeId;
	
	@Column (name = "EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name = "DESIGNATION")
	private String designation;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "EMPLOYEE_ID")
//	private List<Skill> skills;
	
	public Employee () {
		
	}

	public Employee(Long id, String name, String designation) {
		super();
		this.employeeId = id;
		this.employeeName = name;
		this.designation = designation;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_skill", 
    	joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "employee_id"), 
    	inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "skill_id"))
	private List<Skill> skills;

}