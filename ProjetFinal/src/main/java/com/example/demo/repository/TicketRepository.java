package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.beans.Client;
import com.example.demo.beans.Developpeur;
import com.example.demo.beans.Ticket;
import com.example.demo.beans.User;



public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
    public List<Ticket> findByStatut(Boolean s);
    public List<Ticket> findByClient(Client c);
    public List<Ticket> findByDev(Developpeur d);
      @Query("select t from Ticket t  where t.dev is NULL")
      public List<Ticket> ticketNonAttribue();
}
