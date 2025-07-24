
package com.example.finapp.controller;
import com.example.finapp.entity.User;
import com.example.finapp.service.UserService1;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService1 service;
    public UserController(UserService1 service) { this.service = service; }
    @GetMapping public List<User> all() { return service.all(); }
    @GetMapping("/{id}") public User get(@PathVariable Long id) { return service.get(id); }
    @PostMapping public User create(@RequestBody User u) { return service.create(u); }
    @PutMapping("/{id}") public User update(@PathVariable Long id, @RequestBody User u) { return service.update(id, u); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}
