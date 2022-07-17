package com.userregistration.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    @Test
    void shouldGetName() {
        String username = "User Name";
        UserDTO userDTO = new UserDTO();
        userDTO.setName(username);
        String resultTest = userDTO.getName();
        Assertions.assertEquals(username, resultTest);
    }

    @Test
    void shouldGetEmail() {
        String email = "email@email.com";
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        String resultTest = userDTO.getEmail();
        Assertions.assertEquals(email, resultTest);
    }

    @Test
    void shouldGetPassword() {
        String password = "123456";
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword(password);
        String resultTest = userDTO.getPassword();
        Assertions.assertEquals(password, resultTest);
    }

    @Test
    void shouldInstantiateUserDTOWithAllArguments() {
        UserDTO userDTO = new UserDTO("User Name", "email@email.com", "123456");
        Assertions.assertNotNull(userDTO);
    }

}
