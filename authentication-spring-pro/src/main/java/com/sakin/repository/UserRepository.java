package com.sakin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakin.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
