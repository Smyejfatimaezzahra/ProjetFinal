package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Administrateur;
import com.example.demo.beans.Developpeur;
import com.example.demo.beans.Ticket;
import com.example.demo.beans.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.DevRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository ar;
	@Autowired
	TicketRepository tr;
	@Autowired
	DevRepository dr;
	@Autowired
   UserService ur;
	
	public List<Ticket> ticketsNonAttribue(){
		return tr.ticketNonAttribue();
		
	}
   
	public void attribuer(int idT,int idU,int idA) {
		 
		Developpeur u=dr.findById(idU).get();
		Ticket t=tr.findById(idT).get();
		Administrateur a=ar.findById(idA).get();
		if(t!=null) {
		if(a!=null) {
			a.getTickets().add(t);
			ar.save(a);
			}
			if(u!=null) {
				t.setDev(u);
				tr.save(t);
			}}
		
	
	}
	
	public Ticket ticket(int id) {
		return tr.findById(id).get();
	}
	public void createUser(User u) {
		ur.createUser(u);;
	}
	

}
