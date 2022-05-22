package com.example.demo.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.beans.Ticket;
import com.example.demo.service.DevService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("mvc/devs")
public class DevRController {

	@Autowired
	DevService ds;
	@Autowired
	UserService us;
	
	@GetMapping
	public String tickets(Model m) {
		m.addAttribute("bugs",ds.tickets(us.getUserAuth().getId()));
		return "dev/liste";
	}
	
	@GetMapping("/edit/{id}")
	public String modifier(@PathVariable int id,Model m) {
		Ticket t= ds.findTicket(id);
		m.addAttribute("t",t);
		return "dev/modifier" ;
		
	}
	@PostMapping()
	public String enregistrer(@ModelAttribute("t") Ticket t) {
		//t.setDev(ds.findById(us.getUserAuth().getId()));
		ds.modiferStatut(t.getId(),t.getStatut());
		return  "redirect:/mvc/devs";
	}
	
	
}
