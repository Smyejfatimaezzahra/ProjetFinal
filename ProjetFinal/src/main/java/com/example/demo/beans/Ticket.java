package com.example.demo.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Ticket {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private String urgence;
	private String envE;
	private String logiciel;
	private String statut;
	@ManyToOne
	private Client client ;
	@ManyToOne
	private Developpeur dev;

	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnvE() {
		return envE;
	}

	public void setEnvE(String envE) {
		this.envE = envE;
	}

	public int getIdT() {
		return id;
	}

	public void setIdT(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrgence() {
		return urgence;
	}

	public void setUrgence(String urgence) {
		this.urgence = urgence;
	}

	public String getEnvExecu() {
		return envE;
	}

	public void setEnvExecu(String envExecu) {
		this.envE = envExecu;
	}

	public String getLogiciel() {
		return logiciel;
	}

	public void setLogiciel(String logiciel) {
		this.logiciel = logiciel;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Developpeur getDev() {
		return dev;
	}

	public void setDev(Developpeur dev) {
		this.dev = dev;
	}

	
}
