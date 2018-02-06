package com.tech.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.domain.Employee;
import com.tech.repository.EmployeeRepository;
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

	@Override
	public Employee get(Long employeeId) {
		return employeeRepository.findOne(employeeId);
	}

	@Override
	public Map<String, List<Integer>> getAllEmployeesForDashboard() {
		List<Employee> employeeList = new ArrayList<>();
		employeeRepository.findAll().iterator().forEachRemaining(employeeList::add);
		Map<String, List<Integer>> theMap = getDashboardMap(employeeList);
		//theMap.put("All", getAllEmployeesProjectAndBenchDetails(theMap));
		return theMap;
	}
	
	private Map<String, List<Integer>> getDashboardMap(List<Employee> employeeList) {
		
		Map<String, List<Integer>> theMap = new LinkedHashMap<String, List<Integer>>();
		Set<String> skillSet = new LinkedHashSet<String>();
		updateSkillSetAndAllEmployeesCount(employeeList,skillSet,theMap);
		for (String skill : skillSet) {
			getDashBoardMap(employeeList, theMap, skill);
		}
		return theMap;
	}
	
	private Map<String, List<Integer>> getDashBoardMap(List<Employee> employeeList, Map<String, List<Integer>> theMap, String skill) {
		List<Integer> employeeCount = new ArrayList<Integer>(2);
		employeeCount.add(0);
		employeeCount.add(0);
		for (Employee e: employeeList) {
			String isInProject = e.getIsInProject();
			
			if (isInProject.equalsIgnoreCase("yes")) {
				Set<String> employeeSkillSet = e.getSkills();
				if (employeeSkillSet.contains(skill)) {
					Integer value = 0;
					if (theMap.get(skill) != null) {
						value = theMap.get(skill).get(0);
						value = value + 1;
						employeeCount.set(0, value);
					} else {
						employeeCount.set(0, value + 1);
					}
				} 
				
			} else if (isInProject.equalsIgnoreCase("no")) {
				Set<String> employeeSkillSet = e.getSkills();
				if (employeeSkillSet.contains(skill)) {
					Integer value = 0;
					if (theMap.get(skill) != null) {
						value = theMap.get(skill).get(1);
						value = value + 1;
						employeeCount.set(1, value);
					} else {
						employeeCount.set(1, value + 1);
					}
				} 
				
			}
			theMap.put(skill, employeeCount);
			
		}
		return theMap;
	}
	
	private void updateSkillSetAndAllEmployeesCount(List<Employee> employeeList, Set<String> skillSet, Map<String, List<Integer>> theMap) {
		List<Integer> employeeCount = new ArrayList<Integer>(2);
		Integer inProjectCount = 0;
		Integer inBenchCount = 0;
		
		for (Employee e : employeeList) {
			Set<String> employeeSkillSet = e.getSkills();
			skillSet.addAll(employeeSkillSet);
			
			String isInProject = e.getIsInProject();
			if (isInProject.equalsIgnoreCase("yes")) {
				inProjectCount ++;
			} else if (isInProject.equalsIgnoreCase("no")) {
				inBenchCount ++;
			}
		}
		employeeCount.add(inProjectCount);
		employeeCount.add(inBenchCount);
		theMap.put("All", employeeCount);
	}
	
//	private List<Integer> getAllEmployeesProjectAndBenchDetails(Map<String, List<Integer>> theMap) {
//		List<Integer> employeeCount = new ArrayList<Integer>(2);
//		Integer inProjectCount = 0;
//		Integer inBenchCount = 0;
//		
//		for(String skill : theMap.keySet()) {
//			List<Integer> skillCount = theMap.get(skill);
//			inProjectCount = inProjectCount+skillCount.get(0);
//			inBenchCount = inProjectCount+skillCount.get(1);
//		}
//		
//		employeeCount.add(inProjectCount);
//		employeeCount.add(inBenchCount);
//		return employeeCount;
//	}
//	
}
