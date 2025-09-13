package com.example.scm20.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scm20.entities.User;

public interface UserRepo extends JpaRepository<User, String> {


    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

}
