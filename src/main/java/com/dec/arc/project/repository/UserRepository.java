package com.dec.arc.project.repository;


import com.dec.arc.project.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Optional: findByEmail(String email);
}
