package com.service;

import java.util.List;

import com.dto.AuthRequest;
import com.dto.AuthResponse;
import com.dto.RegisterRequest;
import com.dto.RegisterResponse;
import com.entity.User;

import jakarta.validation.Valid;

public interface AuthService {

	RegisterResponse registerUser(@Valid RegisterRequest registerRequest);

	List<User> getUsers();

	AuthResponse userLogin(@Valid AuthRequest authRequest);

}
