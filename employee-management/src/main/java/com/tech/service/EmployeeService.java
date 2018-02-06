package com.tech.service;

import java.util.List;
import java.util.Map;

import com.tech.domain.Employee;

public interface EmployeeService {
	public Employee save(Employee e);
	public void delete(Long employeeId);
	public List<Employee> getEmployees();
	public Employee get(Long employeeId);
//	public List<Employee> getEmployees(String skill);
	public Map<String, List<Integer>> getAllEmployeesForDashboard();
}
