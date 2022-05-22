package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.UpperCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.beans.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class UserService implements UserDetailsService {
	@Autowired
	UserRepository ur;

	@Autowired
	PasswordEncoder passwordEncoder;
	public void createUser(User u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
	   ur.save(u);
	}

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = ur.findByLogin(login);
		 if (user == null) throw new UsernameNotFoundException("Nom d'utilisateur ou mot de passe erroné");
	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+user.getClass().getSimpleName().toUpperCase()));
	        
		 return new
		org.springframework.security.core.userdetails.User(user.getLogin(),
		user.getPassword(),grantedAuthorities);
		 
	}
	public User getUserAuth() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		String login=auth.getName();
		return ur.findByLogin(login);	}
	

}
