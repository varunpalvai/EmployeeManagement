package com.tech.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.dao.EmployeeDao;
import com.tech.domain.Employee;
import com.tech.service.EmployeeService;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Employee save(Employee e) {
		Employee newEmployee = employeeDao.save(e);
		return newEmployee;
	}

	@Override
	public void delete(Long employeeId) {
		employeeDao.delete(employeeId);
		
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		employeeDao.findAll().iterator().forEachRemaining(employeeList::add);
		return employeeList;
	}

}
