package com.dec.arc.project.service;

import com.dec.arc.project.User.User;
import com.dec.arc.project.dto.UserDTO;
import com.dec.arc.project.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    // Constructor injection
    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User createUser(UserDTO dto) {
        User user = new User(dto.getName(), dto.getEmail());
        return repo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return repo.findById(id);
    }

    @Override
    public User updateUser(Long id, UserDTO dto) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return repo.save(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
