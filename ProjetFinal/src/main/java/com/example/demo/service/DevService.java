package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Developpeur;
import com.example.demo.beans.Ticket;
import com.example.demo.beans.User;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.DevRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;

@Service
public class DevService {
	@Autowired
	DevRepository dr;
	@Autowired
	TicketRepository tr;
	@Autowired
	UserRepository ur;
	
	public List<Ticket> tickets(int idD){
		Developpeur d=dr.findById(idD).get();
		return  tr.findByDev(d);
	}
  public void modiferStatut(int id,String statut) {
	  Ticket t=findTicket(id);
	  if(t!=null) {
		  t.setStatut(statut);
		  tr.save(t);
	  }
	  
  }
  public List<Developpeur> findAll(){
	return  dr.findAll();
  }
  
  public Ticket findTicket(int id) {
	  return  tr.findById(id).get();
  }
  
  public Developpeur findById(int id) {
	  return dr.getById(id);
  }
}
