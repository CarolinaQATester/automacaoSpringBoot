package com.automacao.springboot.automacaospringboot.service.impl;

import com.automacao.springboot.automacaospringboot.model.User;
import com.automacao.springboot.automacaospringboot.repository.UserRepository;
import com.automacao.springboot.automacaospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmailEquals(email);
    }
}
