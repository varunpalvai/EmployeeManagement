package com.tech.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "SKILL")
public class Skill {
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	@Column (name = "SKILL_ID")
    private Long skil_id;
	
    @Column (name = "SKILL_NAME")
    private String name;
    
    @Column (name = "LEVEL")
    private Long level;

	public Long getSkil_id() {
		return skil_id;
	}

	public void setSkil_id(Long skil_id) {
		this.skil_id = skil_id;
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
	private List<Employee> employees;
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
