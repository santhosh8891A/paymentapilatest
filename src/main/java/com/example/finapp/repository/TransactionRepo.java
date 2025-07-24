
package com.example.finapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.finapp.entity.Transaction;
public interface TransactionRepo extends JpaRepository<Transaction, Long> {}
