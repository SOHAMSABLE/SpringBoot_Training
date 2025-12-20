package com.dec.arc.project.repository;


import com.dec.arc.project.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Optional: findByEmail(String email);
    Optional<User> findByUsername(String username);
}
