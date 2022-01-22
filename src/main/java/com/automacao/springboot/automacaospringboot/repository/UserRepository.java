package com.automacao.springboot.automacaospringboot.repository;

import com.automacao.springboot.automacaospringboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends GenericRepository<User>{

    Optional<User> findByEmailEquals(String email);
}
