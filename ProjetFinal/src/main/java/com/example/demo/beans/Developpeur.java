package com.example.demo.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Developpeur extends User{

	public Developpeur(String login, String password) {
		this.login=login;
		this.password=password;
	}
	
	public Developpeur() {
		
	}
	
	
}
