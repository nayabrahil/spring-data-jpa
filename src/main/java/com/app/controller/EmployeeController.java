package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.domain.entity.Employee;
import com.app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/insertEmployee",method=RequestMethod.POST)
	public String home(Employee employee, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			return "test";
		}
		
		
		model.addAttribute("employee", employeeService.insertEmployee(employee));
		return "result";
	}
}
