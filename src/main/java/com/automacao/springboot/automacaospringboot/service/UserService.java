package com.automacao.springboot.automacaospringboot.service;

import com.automacao.springboot.automacaospringboot.model.User;


import java.util.Optional;

public interface UserService{

    User save(User user);
    Optional<User> findByEmail(String email);
}
