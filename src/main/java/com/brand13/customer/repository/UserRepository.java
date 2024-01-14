package com.brand13.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brand13.customer.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
    User findByUsername(String username);
}
