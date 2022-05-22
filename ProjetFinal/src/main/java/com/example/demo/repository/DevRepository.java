package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.beans.Developpeur;
import com.example.demo.beans.Ticket;

public interface  DevRepository extends JpaRepository<Developpeur, Integer> {
	

}
