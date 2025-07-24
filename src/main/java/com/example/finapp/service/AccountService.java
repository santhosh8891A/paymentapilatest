
package com.example.finapp.service;
import com.example.finapp.entity.Account;
import com.example.finapp.repository.AccountRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepo repo;
    public AccountService(AccountRepo repo) { this.repo = repo; }
    public List<Account> all() { return repo.findAll(); }
    public Account get(Long id) { return repo.findById(id).orElseThrow(); }
    public Account create(Account a) { return repo.save(a); }
    public Account update(Long id, Account a) { a.setAccountId(id); return repo.save(a); }
    public void delete(Long id) { repo.deleteById(id); }
}
