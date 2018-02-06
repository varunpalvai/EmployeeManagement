package com.tech.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="EMPLOYEE")
public class Employee {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name = "EMPLOYEE_ID")
	private Long employeeId;
	
	@Column (name = "REGISTERED_ID")
	@NotNull
	private String registeredId;
	
	@Column (name = "EMPLOYEE_NAME")
	@NotNull
	private String employeeName;
	
	@Column(name = "DESIGNATION")
	@NotNull
	private String designation;
	
	@Column(name = "PROJECT_NAME")
	private String projectName;
	
	@Column(name = "IS_IN_PROJECT")
	@NotNull
	private String isInProject;
	
	public void setRegisteredId(String registeredId) {
		this.registeredId = registeredId;
	}
	
	public String getRegisteredId() {
		return registeredId;
	}
	
	public void setIsInProject(String isInProject) {
		this.isInProject = isInProject;
	}
	
	public String getIsInProject() {
		return isInProject;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public Employee () {
		
	}

	public Employee(Long id, String name, String designation, String projectName, String isInProject) {
		super();
		this.employeeId = id;
		this.employeeName = name;
		this.designation = designation;
		this.projectName = projectName;
		this.isInProject = isInProject;
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

	public Set<String> getSkills() {
		return skills;
	}

	public void setSkills(Set<String> skills) {
		this.skills = skills;
	}
	
	@ElementCollection
    @CollectionTable(name = "employee_skill", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "skill_id")
    private Set<String> skills = new HashSet<>();
	
//	@ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "employee_skill", 
//    	joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "employee_id"), 
//    	inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "skill_id"))
//	//@JsonManagedReference
//	private Set<Skill> skills;

}