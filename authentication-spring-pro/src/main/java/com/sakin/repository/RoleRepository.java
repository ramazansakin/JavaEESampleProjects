package com.sakin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sakin.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
