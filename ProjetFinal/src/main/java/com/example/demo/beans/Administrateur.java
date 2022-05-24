package com.example.demo.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Administrateur extends User{

	

	@ManyToMany
	private List<Ticket> tickets;
	
	public Administrateur() {
		
	}
	public Administrateur(String login, String password) {
		this.login=login;
		this.password=password;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
