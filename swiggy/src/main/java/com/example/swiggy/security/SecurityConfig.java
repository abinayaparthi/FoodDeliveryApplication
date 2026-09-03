package com.example.swiggy.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	@Autowired
	customerUserDetailsService cs;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http
		.userDetailsService(cs)
		.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth->auth
				
			.requestMatchers("/auth/**").permitAll()
			.requestMatchers("/admin/**").hasRole("ADMIN")
			.requestMatchers("/customer/**").hasRole("CUSTOMER")
			.requestMatchers("/delivery/**").hasRole("DELIVERY_PARTNER")
			.anyRequest().authenticated()	
		)
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordencode()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	

}
