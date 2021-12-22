package com.automacao.springboot.automacaospringboot.repository;

import com.automacao.springboot.automacaospringboot.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    private static final String EMAIL = "teste@teste.com.br";

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp(){
        User user = new User();
        user.setName("Set up user");
        user.setPassword("senha12356");
        user.setEmail(EMAIL);
        userRepository.save(user);

    }
    @After
    public void tearDown(){
        userRepository.deleteAll();
    }

    @Test
    public void testSalvar(){
        User user = new User();
        user.setName("Teste");
        user.setPassword("senha123456");
        user.setEmail("teste@teste.com.br");

        User response = userRepository.save(user);

        assertNotNull(response);
        System.out.println(response);
    }
    @Test
    public void testFindByEmail(){
        Optional <User> response = userRepository.findByEmailEquals(EMAIL);

        assertTrue(response.isPresent());
        assertEquals(response.get().getEmail(), EMAIL);
    }
}