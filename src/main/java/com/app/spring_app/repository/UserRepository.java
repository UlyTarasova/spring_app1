package com.app.spring_app.repository;

import com.app.spring_app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByLogin(String login);
}
