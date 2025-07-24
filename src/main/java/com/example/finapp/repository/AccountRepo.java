
package com.example.finapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.finapp.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
