
package com.example.finapp.controller;

import com.example.finapp.entity.Transaction;
import com.example.finapp.entity.User;
import com.example.finapp.security.AppUserDetails;
import com.example.finapp.service.TransactionService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {
	private final TransactionService service;

	public TransactionController(TransactionService service) {
		this.service = service;
	}

	@GetMapping
	public List<Transaction> all() {
		return service.all();
	}

	@GetMapping("/{id}")
	public Transaction get(@PathVariable Long id) {
		return service.get(id);
	}

	@PostMapping
	public Transaction create(@RequestBody Transaction t) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AppUserDetails userDetails = (AppUserDetails) auth.getPrincipal();
		Long userId = userDetails.getDomainUser().getUserId();
		User user = new User();
		user.setUserId(userId);
		t.setUser(user);
		return service.create(t);
	}

	@PutMapping("/{id}")
	public Transaction update(@PathVariable Long id, @RequestBody Transaction t) {
		return service.update(id, t);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
