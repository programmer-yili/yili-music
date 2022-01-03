package com.bilitech.yilimusic.repository;

import com.bilitech.yilimusic.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, String> {
    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    User getById(String id);

    Page<User> findAll(Pageable pageable);
}
