package com.automacao.springboot.automacaospringboot.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {

    private Long id;
    @NotBlank(message = "{name.not.blank}")
    @Length(min=3, max=50, message = "O nome deve conter entre 3 e 50 caracteres")
    private String name;
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "Email invalido")
    private String email;
    @NotBlank(message = "{password.not.blank}")
    private String password;
}
