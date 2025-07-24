
package com.example.finapp.service;
import com.example.finapp.entity.Transaction;
import com.example.finapp.repository.TransactionRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepo repo;
    public TransactionService(TransactionRepo repo) { this.repo = repo; }
    public List<Transaction> all() { return repo.findAll(); }
    public Transaction get(Long id) { return repo.findById(id).orElseThrow(); }
    public Transaction create(Transaction t) { return repo.save(t); }
    public Transaction update(Long id, Transaction t) { t.setTransactionId(id); return repo.save(t); }
    public void delete(Long id) { repo.deleteById(id); }
}
