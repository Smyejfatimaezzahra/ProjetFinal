package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Developpeur;
import com.example.demo.beans.User;

public interface  UserRepository extends JpaRepository<User, Integer> {
	User findByLogin(String login); 

}
