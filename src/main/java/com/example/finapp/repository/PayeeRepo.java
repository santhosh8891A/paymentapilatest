
package com.example.finapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.finapp.entity.Payee;
public interface PayeeRepo extends JpaRepository<Payee, Long> {}
