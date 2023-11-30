package com.manerstech.UserManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.manerstech.UserManager.entities.Employee;
import com.manerstech.UserManager.entities.myEmployeeList;
import com.manerstech.UserManager.service.EmployeeService;
import com.manerstech.UserManager.service.myEmployeeListService;

@Controller
public class firstController {
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private myEmployeeListService myEmpService;
	
	@GetMapping("/")
	public String openHomePage() {
		return "home";
	}
	
	@GetMapping("/employee_register")
	public String registerEmployee() {
		return "registerEmployee";
	}
	
	@GetMapping("/available_employees")
	public ModelAndView getAllEmployees() {
		List<Employee> list=empService.getAllEmployees();
		/*
		 * ModelAndView m=new ModelAndView(); m.setViewName("Employee List");
		 * m.addObject("emp", list);
		 */
		return new ModelAndView("employeeList","employee",list);
	}
	
	@PostMapping("/save")
	public String addEmployee(@ModelAttribute Employee emp){
		empService.save(emp);
		return "redirect:/available_employees";
	}
	
	@GetMapping("/my_employees")
	public String getMyEmployees(Model model) {
		List<myEmployeeList> list=myEmpService.getAllMyEmployees();
		model.addAttribute("employee",list);
		return "myEmployees";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Employee emp=empService.getEmployeeById(id);
		myEmployeeList mel=new myEmployeeList(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getPhone(),emp.getSalary());
		myEmpService.saveMyEmployee(mel);
		return "redirect:/my_employees";
	}
	
	@RequestMapping("/editEmployee/{id}")
	public String editEmployee(@PathVariable("id") int id,Model model) {
		Employee emp= empService.getEmployeeById(id);
		model.addAttribute("employee", emp);
		return "employeeEdit";
	}
	
	@RequestMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		empService.deleteEmployeeById(id);
		return "redirect:/available_employees";
	}
	
	
}
