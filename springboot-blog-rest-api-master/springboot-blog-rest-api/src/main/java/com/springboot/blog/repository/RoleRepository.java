package com.springboot.blog.repository;

import com.springboot.blog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
    // JpaRepository:
    // A Spring Data interface that provides pre-defined methods to perform database
    // Includes methods such as save(), findById(), delete(), and more.