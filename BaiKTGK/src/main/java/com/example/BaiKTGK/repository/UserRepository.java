package com.example.BaiKTGK.repository;

import com.example.BaiKTGK.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}