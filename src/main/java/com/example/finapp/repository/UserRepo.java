
package com.example.finapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.finapp.entity.User;
import java.util.Optional;
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
