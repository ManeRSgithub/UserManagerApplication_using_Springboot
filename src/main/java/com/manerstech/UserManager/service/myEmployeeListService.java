package com.manerstech.UserManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manerstech.UserManager.entities.myEmployeeList;
import com.manerstech.UserManager.repository.MyEmployeeRepository;

@Service
public class myEmployeeListService {
	
	@Autowired
	private MyEmployeeRepository myemployee;
		
	public void saveMyEmployee(myEmployeeList employeeList) {
		
		myemployee.save(employeeList);
	}
	
	public List<myEmployeeList> getAllMyEmployees(){
		
		return myemployee.findAll();
	}
	
	public void deleteById(int id) {
		myemployee.deleteById(id);
	}
	
	
	
	}
