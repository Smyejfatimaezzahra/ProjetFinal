package com.example.demo.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.beans.Client;
import com.example.demo.beans.User;
import com.example.demo.service.UserService;



@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    UserService us;
	@GetMapping("inscription")
	public String insc(Model m) {
		m.addAttribute("user",new Client());
		return "inscription";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("inscription")
	public String insc(@ModelAttribute Client user,BindingResult result) {
		if (result.hasErrors())
			return "inscription";
		us.createUser(user);
		return "redirect:/login";
	}
}
