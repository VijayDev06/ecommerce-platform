package com.security;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUserDetails extends UserDetailsService {
	
	
	String getEmail();
	
	

}
