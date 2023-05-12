package com.codegym.service.impl;

import com.codegym.model.user.User;
import com.codegym.repository.IUserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public Boolean existsByEmail(String email) {
        return iUserRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return iUserRepository.existsByUsername(username);
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }


    @Override
    public User findById(Integer id) {
        return iUserRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return iUserRepository.findById(id).get();
    }
}
