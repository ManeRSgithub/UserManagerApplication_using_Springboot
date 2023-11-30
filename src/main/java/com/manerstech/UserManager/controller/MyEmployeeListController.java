package com.manerstech.UserManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.manerstech.UserManager.service.myEmployeeListService;

@Controller
public class MyEmployeeListController {
    
	@Autowired
	private myEmployeeListService empListService;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		empListService.deleteById(id);
		return "redirect:/my_employees";
	}
}
