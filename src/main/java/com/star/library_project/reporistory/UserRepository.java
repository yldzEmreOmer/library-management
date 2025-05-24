package com.star.library_project.reporistory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.library_project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
