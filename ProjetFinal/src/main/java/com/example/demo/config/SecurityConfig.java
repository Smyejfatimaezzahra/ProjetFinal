package com.example.demo.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.example.demo.service.UserService;




@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder);
		return auth;

	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.httpBasic().and().authorizeRequests()
				.mvcMatchers("/", "/login", "/logout","/inscription").permitAll()
				.mvcMatchers("mvc/admins").hasRole("ADMINISTRATEUR")
				.mvcMatchers("mvc/devs").hasRole("DEVELOPPEUR")
				.mvcMatchers("mvc/clients").hasRole("CLIENT")
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login")
		 		.and()
				.logout()
				.clearAuthentication(true).invalidateHttpSession(true)
				;
		http
	    .formLogin(formLogin -> formLogin
	        .successHandler(new CustomAuthenticationSuccessHandler())
	    );
		
	}
	
	
}