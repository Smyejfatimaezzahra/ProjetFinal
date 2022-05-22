package com.example.demo.rest.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Ticket;
import com.example.demo.beans.User;
import com.example.demo.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	@Autowired
	ClientService cs;

	@GetMapping("{idU}")
	public List<Ticket> tickets(@PathVariable int idU) {

		return cs.tickets(idU);

	}

	@PostMapping
	public void creerTikcet(@RequestBody Ticket t) {
		cs.creerTikcet(t);

	}

}
