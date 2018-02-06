package com.tech.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.domain.Employee;
import com.tech.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello";
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		List<Employee> employeetList = employeeService.getEmployees();
		return employeetList;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee save(@RequestBody Employee e) {
		Employee newEmployee = employeeService.save(e);
		return newEmployee;
	}
	
	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
	public Employee get(@PathVariable(name = "employeeId") Long employeeId) {
		Employee employee = employeeService.get(employeeId);
		return employee;
	}
	
	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(name = "employeeId") Long employeeId) {
		employeeService.delete(employeeId);
		return "employee deleted successfully";
	}
	
	@RequestMapping(value = "/getEmployeesDashboard", method = RequestMethod.GET)
	public Map<String,List<Integer>> getAllEmployeesForDashboard() {
		return employeeService.getAllEmployeesForDashboard();
	}
}
