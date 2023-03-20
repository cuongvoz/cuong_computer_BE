package com.codegym.service;

import com.codegym.model.user.User;

import java.util.List;
import java.util.Optional;

public interface IUserService   {
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    void save(User user);
    Optional<User> findByUsername(String username);
    Optional<User> findById(Integer id);
    List<User> findAll();
    User findById(int id);
}
