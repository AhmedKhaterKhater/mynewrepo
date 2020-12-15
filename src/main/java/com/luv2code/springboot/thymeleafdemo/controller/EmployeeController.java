package com.luv2code.springboot.thymeleafdemo.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;



@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		
		List<Employee> theEmployees=employeeService.findAll();
		model.addAttribute("employees",theEmployees);
		
		return "/employees/list-employees";
	}
	
	@RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
	public String showFormForAdd(Model model) {
		
		Employee theEmployee=new Employee();
		
		model.addAttribute("employee" , theEmployee);
		
		return "/employees/employee-form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		
		employeeService.save(emp);
		
		return "redirect:/employees/list";
	}
	
}
