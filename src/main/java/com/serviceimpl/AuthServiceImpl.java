package com.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.RegisterRequest;
import com.dto.RegisterResponse;
import com.entity.User;
import com.enums.Role;
import com.exceptions.ResourceFoundException;
import com.repository.UserRepository;
import com.service.AuthService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public RegisterResponse registerUser(@Valid RegisterRequest registerRequest) {
		
		log.info("Registered User Details" + registerRequest);
		
		userRepository.findByEmail(registerRequest.getEmail()).ifPresent((user) -> {
			throw new ResourceFoundException("User with this email already exists");
		});
		
		ModelMapper modal = new ModelMapper();
		User user = modal.map(registerRequest, User.class);
		
//		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setRole(Role.USER);
		
		User savedUser = userRepository.save(user);
		
		RegisterResponse rr = modal.map(savedUser, RegisterResponse.class);
		
		return rr;
	}

	@Override
	public List<User> getUsers() {
		
		List<User> u =userRepository.findAll();
		
		return u;
	}

}
