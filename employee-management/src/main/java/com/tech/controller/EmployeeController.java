package com.tech.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tech.domain.Employee;

@RestController
public class EmployeeController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello";
	}

	private static Map<String, List<Employee>> employeeDB = new HashMap<String, List<Employee>>();

	static {
		employeeDB = new HashMap<String, List<Employee>>();

		List<Employee> lst = new ArrayList<Employee>();
		Employee emp = new Employee(1, "rajesh", "TeamLead");
		lst.add(emp);
		emp = new Employee(2, "Lokesh", "SeniorSoftwareEngineer");
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
}
