
package com.example.finapp.service;
import com.example.finapp.entity.Payee;
import com.example.finapp.repository.PayeeRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PayeeService {
    private final PayeeRepo repo;
    public PayeeService(PayeeRepo repo) { this.repo = repo; }
    public List<Payee> all() { return repo.findAll(); }
    public Payee get(Long id) { return repo.findById(id).orElseThrow(); }
    public Payee create(Payee p) { return repo.save(p); }
    public Payee update(Long id, Payee p) { p.setPayeeId(id); return repo.save(p); }
    public void delete(Long id) { repo.deleteById(id); }
}
