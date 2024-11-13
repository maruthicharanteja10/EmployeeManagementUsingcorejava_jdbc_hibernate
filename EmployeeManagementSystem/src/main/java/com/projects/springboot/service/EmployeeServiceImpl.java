package com.projects.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projects.springboot.model.Employee;
import com.projects.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> listAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployeet(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmpolyee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void DeleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
