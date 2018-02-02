package com.tech.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table (name = "SKILL")
public class Skill {
	
	public Skill() {
		
	}
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name = "SKILL_ID")
    private Long skillId;
	
    @Column (name = "SKILL_NAME")
    private String name;
    
    @Column (name = "LEVEL")
    private Long level;

	public Long getSkillId() {
		return skillId;
	}
	
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}
	
	@ManyToMany(mappedBy = "skills", fetch = FetchType.LAZY)
	//@JsonBackReference
	@JsonIgnore
	private Set<Employee> employees;
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
}
