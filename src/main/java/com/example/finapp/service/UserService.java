package com.example.finapp.service;

import com.example.finapp.dto.AuthRegisterRequest;
import com.example.finapp.entity.User;
import com.example.finapp.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepo repo;
	private final PasswordEncoder encoder;

	public List<User> all() {
		return repo.findAll();
	}

	public User get(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
	}

	public User register(AuthRegisterRequest req) {
		if (repo.findByUsername(req.getUsername()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists");
		}
		User u = User.builder().username(req.getUsername()).passwordHash(encoder.encode(req.getPassword()))
				.txPasswordHash(encoder.encode(req.getTxPassword())).build();
		return repo.save(u);
	}

	/** Simple update; not exposed publicly in auth flow */
	public User save(User user) {
		return repo.save(user);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
