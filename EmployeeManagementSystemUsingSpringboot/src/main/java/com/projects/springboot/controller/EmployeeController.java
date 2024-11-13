package com.projects.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projects.springboot.model.Employee;
import com.projects.springboot.service.EmployeeService;

@Controller
public class EmployeeController {
	EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.listAllEmployees());
		return "list_employees";

	}

	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "create_employees";
	}

	@PostMapping("/employees")
	public String saveEmployeeData(@ModelAttribute Employee emp) {
		employeeService.saveEmployeet(emp);
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String EditEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employees";

	}

	@PostMapping("/employees/{id}")
	public String UpdateEmployeeData(@ModelAttribute("employee") Employee emp, @PathVariable Long id) {
		Employee existedEmpl =employeeService.getEmployeeById(id);
		existedEmpl.setId(id);
		existedEmpl.setFirstname(emp.getFirstname());
		existedEmpl.setLastname(emp.getLastname());
		existedEmpl.setEmail(emp.getEmail());
		employeeService.updateEmpolyee(existedEmpl);
		return "redirect:/employees";

	}

	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		employeeService.DeleteEmployee(id);
		return "redirect:/employees";

	}
}
