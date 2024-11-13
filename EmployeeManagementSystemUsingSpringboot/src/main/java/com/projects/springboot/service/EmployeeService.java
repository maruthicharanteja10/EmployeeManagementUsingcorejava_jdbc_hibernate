package com.projects.springboot.service;

import java.util.List;

import com.projects.springboot.model.Employee;

public interface EmployeeService {
	List<Employee> listAllEmployees();

	Employee saveEmployeet(Employee employee);

	Employee getEmployeeById(Long id);

	Employee updateEmpolyee(Employee employee);

	void DeleteEmployee(Long id);

}
