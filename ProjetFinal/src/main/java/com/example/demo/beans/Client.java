package com.example.demo.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Client extends User {

	public Client(String login, String password) {
		// TODO Auto-generated constructor stub
	}

	public Client() {
		// TODO Auto-generated constructor stub
	}
	
    


     
/*	@OneToMany
	private List<Ticket> tickets;

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}*/
}
