package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.domain.entity.Employee;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(ModelMap model){
		model.addAttribute("message","testMessage");
		model.addAttribute("employee", new Employee());
		return "test";
	}
	
	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("message", "welcomeMessage");
        return "showMessage";
    }
}
