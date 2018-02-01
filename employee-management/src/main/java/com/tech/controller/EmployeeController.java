package com.tech.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

	private static Map<String, List<Employee>> employeeDB = new HashMap<String, List<Employee>>();

	static {
		employeeDB = new HashMap<String, List<Employee>>();

		List<Employee> lst = new ArrayList<Employee>();
		Employee emp = new Employee(1L, "rajesh", "TeamLead");
		lst.add(emp);
		emp = new Employee(2L, "Lokesh", "SeniorSoftwareEngineer");
		lst.add(emp);

		employeeDB.put("gspann", lst);

	}

	
	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		List<Employee> employeetList = new ArrayList<Employee>();
		
		Collection<List<Employee>> values = employeeDB.values();
		
		for(List<Employee> list : values) {
			for(Employee std : list) {
				employeetList.add(std);
			}
		}
		
		return employeetList;
		
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
	
	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(name = "employeeId") Long employeeId) {
		employeeService.delete(employeeId);
		return "employee deleted successfully";
	}
}
