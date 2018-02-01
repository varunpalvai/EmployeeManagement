package com.tech.dao;

import org.springframework.data.repository.CrudRepository;

import com.tech.domain.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Long> {

}
