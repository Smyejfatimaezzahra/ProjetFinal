package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Client;
import com.example.demo.beans.Ticket;
import com.example.demo.beans.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository cr;
	@Autowired
	TicketRepository tr;
	@Autowired
	UserRepository ur;
	
	public List<Ticket> tickets(int idC){
		Client c=cr.findById(idC).get();
		return tr.findByClient(c);
		
	}
   
	public void creerTikcet(Ticket t) {
		t.setStatut("enAttente");
		tr.save(t);
		
	}
	
	public Client findById(int id) {
		return cr.getById(id);
	}
  
}
