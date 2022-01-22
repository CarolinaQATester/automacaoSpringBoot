package com.automacao.springboot.automacaospringboot.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="tb_user")
public class User extends GenericModel {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;


}
