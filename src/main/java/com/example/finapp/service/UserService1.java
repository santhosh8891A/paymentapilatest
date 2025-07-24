
package com.example.finapp.service;

import com.example.finapp.entity.User;
import com.example.finapp.repository.UserRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService1 {
	private final UserRepo repo;

	public UserService1(UserRepo repo) {
		this.repo = repo;
	}

	public List<User> all() {
		return repo.findAll();
	}

	public User get(Long id) {
		return repo.findById(id).orElseThrow();
	}

	public User create(User u) {
		return repo.save(u);
	}

	public User update(Long id, User u) {
		u.setUserId(id);
		return repo.save(u);
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}
