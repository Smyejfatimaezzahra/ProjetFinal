package com.example.demo.mvc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.beans.Administrateur;
import com.example.demo.beans.Developpeur;
import com.example.demo.beans.Ticket;
import com.example.demo.beans.User;
import com.example.demo.service.AdminService;
import com.example.demo.service.DevService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("mvc/admins")
public class AdminRController {
	
	

	@Autowired
	AdminService as;
	@Autowired
	DevService ds;
	@Autowired
	UserService us;

	@GetMapping
	public String bugs(Model m) {
		m.addAttribute("bugs", as.ticketsNonAttribue());
		return "admin/liste";
	}
	@GetMapping("/{id}")
	public String attribuer(@PathVariable int id, Model m) {
		Ticket t = as.ticket(id);
		if (t != null) {
			m.addAttribute("ticket", t);
			m.addAttribute("devs", ds.findAll());
			return "admin/attribuer.html";

		}
		return "admin/bugs";
	}
   @GetMapping("/attribuer")
	public String enregistrer(@RequestParam(value="idT") int idT,@RequestParam(value="idD") int idD) {
	   System.out.print(idT+" "+idD);
		as.attribuer(idT , idD,us.getUserAuth().getId());
		return "redirect:/mvc/admins/";
	}
	
   @GetMapping("/add")
	public String addUser(Model m) {
	   String role="";
		m.addAttribute("user", new User());
		return "user";
	}
   @PostMapping("/add")
  	public String enrgUser(@ModelAttribute("user") User user,@RequestParam(value="role")String role) {
	   if(role.equals("administrateur")) {
		   Administrateur a=new Administrateur(user.getLogin(),user.getPassword());
		   us.createUser(a);
	   }
	   else {
		   Developpeur d=new Developpeur(user.getLogin(),user.getPassword());
		   us.createUser(d);
	   }
  		return "redirect:/mvc/admins/";
  	}
}
