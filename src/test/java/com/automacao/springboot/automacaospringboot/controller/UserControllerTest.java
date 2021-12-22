package com.automacao.springboot.automacaospringboot.controller;

import com.automacao.springboot.automacaospringboot.dto.UserDTO;
import com.automacao.springboot.automacaospringboot.model.User;
import com.automacao.springboot.automacaospringboot.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserControllerTest {

    private static final long ID = 1;
    private static final String NAME ="TESTE";
    private static final String PASSWORD ="Senha123456";
    private static final String EMAIL ="teste@teste.com";
    private static final String URL = "/user";

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;
    @Test
    public void testSave() throws Exception{
        BDDMockito.given(userService.save(Mockito.any(User.class))).willReturn(getMockUser());
        mockMvc.perform(MockMvcRequestBuilders.post(URL)
                .content(getJsonPayload(ID, NAME, PASSWORD, EMAIL))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.id").value(ID))
                .andExpect(jsonPath("$.data.name").value(NAME))
                .andExpect(jsonPath("$.data.password").value(PASSWORD))
                .andExpect(jsonPath("$.data.email").value(EMAIL));

    }
    @Test
    public void testSaveInvalidUser() throws JsonProcessingException, Exception{
            mockMvc.perform(MockMvcRequestBuilders.post(URL)
            .content(getJsonPayload(ID, NAME, PASSWORD, "email"))
            .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.errors.[0]").value("Email invalido"));
    }
    public User getMockUser(){
        User user = new User();
        user.setId(ID);
        user.setName(NAME);
        user.setPassword(PASSWORD);
        user.setEmail(EMAIL);

        return user;
    }
    public String getJsonPayload(Long id, String email, String name, String password) throws JsonProcessingException {
        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setPassword(password);
        dto.setEmail(email);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dto);

    }
}
