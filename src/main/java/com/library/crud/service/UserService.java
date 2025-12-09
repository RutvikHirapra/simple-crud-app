package com.library.crud.service;

import com.library.crud.entity.User;
import com.library.crud.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) { this.repo = repo; }

    public List<User> getAllUsers() { return repo.findAll(); }

    public User getUserById(Long id) { return repo.findById(id).orElse(null); }

    public User createUser(User user) { return repo.save(user); }

    public User updateUser(Long id, User data) {
        User user = repo.findById(id).orElse(null);
        if (user == null) return null;
        user.setName(data.getName());
        user.setEmail(data.getEmail());
        return repo.save(user);
    }

    public void deleteUser(Long id) { repo.deleteById(id); }
}
