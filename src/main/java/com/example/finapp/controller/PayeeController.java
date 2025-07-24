
package com.example.finapp.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finapp.entity.Payee;
import com.example.finapp.entity.User;
import com.example.finapp.security.AppUserDetails;
import com.example.finapp.service.PayeeService;

@RestController
@RequestMapping("/api/payees")
@CrossOrigin(origins = "http://localhost:3000")	
public class PayeeController {
	private final PayeeService service;

	public PayeeController(PayeeService service) {
		this.service = service;
	}

	@GetMapping
	public List<Payee> all() {
		return service.all();
	}

	@GetMapping("/{id}")
	public Payee get(@PathVariable Long id) {
		return service.get(id);
	}

	@PostMapping
	public Payee create(@RequestBody Payee p) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AppUserDetails userDetails = (AppUserDetails) auth.getPrincipal();
		Long userId = userDetails.getDomainUser().getUserId();
		User user = new User();
		user.setUserId(userId);
		p.setUser(user);
		return service.create(p);
	}

	@PutMapping("/{id}")
	public Payee update(@PathVariable Long id, @RequestBody Payee p) {
		return service.update(id, p);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
