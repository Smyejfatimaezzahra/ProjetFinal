package com.example.demo.rest.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Ticket;
import com.example.demo.beans.User;
import com.example.demo.service.DevService;

@RestController
@RequestMapping("/devs")
public class devController {

	@Autowired
	DevService ds;

	@GetMapping("/{id}")
	public List<Ticket> tickets(@PathVariable int id) {
	
		return ds.tickets(id);

	}
    @GetMapping("/{id}/{statut}")
	public void modiferStatut(int id, String statut) {
		    ds.modiferStatut(id, statut);

	}

}
