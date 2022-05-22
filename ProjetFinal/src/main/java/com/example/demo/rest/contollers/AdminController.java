package com.example.demo.rest.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Administrateur;
import com.example.demo.beans.Client;
import com.example.demo.beans.Developpeur;
import com.example.demo.beans.Ticket;
import com.example.demo.beans.User;
import com.example.demo.service.AdminService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	AdminService as;
	@Autowired
	UserService us;
	@PostMapping
	public List<Ticket> ticketsNonAttribue(){
		return as.ticketsNonAttribue();
		
	}
   @GetMapping("/{idT}/{idU}/{idA}")
	public void attribuer(@PathVariable int idT,@PathVariable int idU,@PathVariable int idA) {
		as.attribuer(idT, idU,idA);
		
	}
   @PostMapping("/admin")
   public void createUser(@RequestBody Administrateur a) {
		us.createUser(a);
	}
   
   @PostMapping("/dev")
   public void createUser(@RequestBody Developpeur d) {
		us.createUser(d);
	}
   
   @PostMapping("/client")
   public void createUser(@RequestBody Client c) {
		us.createUser(c);
	}
   
   
}
