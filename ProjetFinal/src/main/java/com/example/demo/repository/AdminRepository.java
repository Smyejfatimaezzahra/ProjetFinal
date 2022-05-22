package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Administrateur;


public interface AdminRepository extends JpaRepository<Administrateur, Integer> {

}
