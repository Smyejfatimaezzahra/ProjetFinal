package com.example.demo.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.beans.Ticket;
import com.example.demo.service.ClientService;
import com.example.demo.service.UserService;



@Controller
@RequestMapping("mvc/clients")
public class ClientRController {
	
	@Autowired
	ClientService cs;
	@Autowired
	UserService us;
	@GetMapping
	public String tickets(Model m) {
		m.addAttribute("bugs",cs.tickets(us.getUserAuth().getId()));
		return "client/liste";
	}
	@GetMapping("/add")
	public String ajout(Model m) {
		Ticket t=new Ticket();
		m.addAttribute("t",t);
		return "client/ajout";
		
	}
@PostMapping("")
	public String enregister(@ModelAttribute("t") Ticket t) {
		t.setClient(cs.findById(us.getUserAuth().getId()));
		cs.creerTikcet(t);;
		return "redirect:/mvc/clients";
	} 
}
