package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.beans.Client;
import com.example.demo.beans.Ticket;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	/*@Query("select c.tickets from Client c where c.id:=idC")
	 public List<Ticket> tickets(@Param("idC") int idC);*/

}
