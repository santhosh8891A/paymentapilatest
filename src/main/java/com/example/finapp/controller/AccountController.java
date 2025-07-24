
package com.example.finapp.controller;
import com.example.finapp.entity.Account;
import com.example.finapp.service.AccountService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {
    private final AccountService service;
    public AccountController(AccountService service) { this.service = service; }
    @GetMapping public List<Account> all() { return service.all(); }
    @GetMapping("/{id}") public Account get(@PathVariable Long id) { return service.get(id); }
    @PostMapping public Account create(@RequestBody Account a) { return service.create(a); }
    @PutMapping("/{id}") public Account update(@PathVariable Long id, @RequestBody Account a) { return service.update(id, a); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}
