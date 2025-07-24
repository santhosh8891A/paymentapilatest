package com.example.finapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finapp.dto.AuthLoginRequest;
import com.example.finapp.dto.AuthRegisterRequest;
import com.example.finapp.dto.AuthResponse;
import com.example.finapp.security.JwtService;
import com.example.finapp.service.AppUserDetailsService;
import com.example.finapp.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationManager authManager;
	private final JwtService jwtService;
	private final AppUserDetailsService userDetailsService;
	private final UserService userService;

	@PostMapping("/auth/register")
	public ResponseEntity<AuthResponse> register(@Valid @RequestBody AuthRegisterRequest req) {
		var user = userService.register(req);
		// Auto-login after register:
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
		String token = jwtService.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponse(token));
	}

	 @PostMapping("/auth/login")
	public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthLoginRequest req) {
		// Triggers password check via AuthenticationProvider
		Authentication auth = new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
		authManager.authenticate(auth);

		UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
		String token = jwtService.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponse(token));
	}
}
