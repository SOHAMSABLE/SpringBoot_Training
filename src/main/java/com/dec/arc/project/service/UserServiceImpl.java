package com.dec.arc.project.service;

import com.dec.arc.project.User.User;
import com.dec.arc.project.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Long, User> userStore = new HashMap<>();
    private Long idCounter = 1L;

    // Constructor injection
    public UserServiceImpl() {}

    @Override
    public User createUser(UserDTO dto) {
        User user = new User(idCounter, dto.getName(), dto.getEmail());
        userStore.put(idCounter, user);
        idCounter++;
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userStore.values());
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userStore.get(id));
    }

    @Override
    public User updateUser(Long id, UserDTO dto) {
        User existing = userStore.get(id);
        if (existing == null) {
            throw new RuntimeException("User not found");
        }

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        return existing;
    }

    @Override
    public boolean deleteUser(Long id) {
        return userStore.remove(id) != null;
    }
}
