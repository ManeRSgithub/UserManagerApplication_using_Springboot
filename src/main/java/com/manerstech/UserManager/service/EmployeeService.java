package com.manerstech.UserManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manerstech.UserManager.entities.Employee;
import com.manerstech.UserManager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository eRepo;
	
	public void save(Employee emp) {
		eRepo.save(emp);
	}
	
	public List<Employee> getAllEmployees(){
		return eRepo.findAll();
	}
	
	public Employee getEmployeeById(int id) {
		return eRepo.findById(id).get();
	}
	
	public void deleteEmployeeById(int id) {
		 eRepo.deleteById(id);
	}
	
}
