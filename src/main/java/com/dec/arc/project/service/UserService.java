package com.dec.arc.project.service;


import com.dec.arc.project.User.User;
import com.dec.arc.project.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(UserDTO dto);
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    User updateUser(Long id, UserDTO dto);
    boolean deleteUser(Long id);
}
