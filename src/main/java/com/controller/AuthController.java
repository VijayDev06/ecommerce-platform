package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.RegisterRequest;
import com.entity.User;
import com.service.AuthService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Tag(name = "Authentication APIS", description = "All APIS Are related to Authentication")
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) {

		log.debug("Register Request: " + registerRequest);

		return ResponseEntity.status(HttpStatus.CREATED).
				body(authService.registerUser(registerRequest));
	}
	
	@GetMapping("/usersinfo")
	public ResponseEntity<?> getUsers(){
		
		List<User> user = authService.getUsers();
		
		return ResponseEntity.status(HttpStatus.OK).
				body(user);
	}

}
