package com.tech.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tech.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	//public List<Employee> findByEmployeeIdAndSkillName(Long employeeId, String skillName);

}
