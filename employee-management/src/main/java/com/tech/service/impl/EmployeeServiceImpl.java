package com.tech.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dao.EmployeeRepository;
import com.tech.domain.Employee;
import com.tech.service.EmployeeService;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee e) {
		Employee newEmployee = employeeRepository.save(e);
		return newEmployee;
	}

	@Override
	public void delete(Long employeeId) {
		employeeRepository.delete(employeeId);
		
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		employeeRepository.findAll().iterator().forEachRemaining(employeeList::add);
		return employeeList;
	}
	
//	@Override
//	public List<Employee> getEmployees(String skill) {
//		List<Employee> employeeList = new ArrayList<>();
//		employeeDao.findB
//		return employeeList;
//	}

}
