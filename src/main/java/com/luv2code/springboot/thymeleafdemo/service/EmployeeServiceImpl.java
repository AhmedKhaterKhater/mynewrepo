package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
		}

	@Override
	public Employee findById(int id) {

		 Optional< Employee> result=employeeRepository.findById(id);
		 
		 Employee theEmployee=null;
		 
		 if(result.isPresent()) {
			 theEmployee=result.get();
		 }
		 
		 return theEmployee;
		
		
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
		
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
		
	}

}
