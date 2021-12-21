package com.automacao.springboot.automacaospringboot.controller;

import com.automacao.springboot.automacaospringboot.dto.UserDTO;
import com.automacao.springboot.automacaospringboot.model.User;
import com.automacao.springboot.automacaospringboot.response.Response;
import com.automacao.springboot.automacaospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserDTO dto, BindingResult result) {
        Response<UserDTO> response = new Response<UserDTO>();
        User user = userService.save(this.convertDtoToModel(dto));
        response.setData(this.convertModelToDto(user));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    private User convertDtoToModel(UserDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());

        return user;
    }
    private UserDTO convertModelToDto(User user){
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());

        return dto;
    }
}

