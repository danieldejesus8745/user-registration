package com.userregistration.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

class UserDTOTest {

    @Test
    void shouldGetUuid() {
        UUID uuid = UUID.randomUUID();
        UserDTO userDTO = new UserDTO();
        userDTO.setUuid(uuid);
        Assertions.assertEquals(uuid, userDTO.getUuid());
    }

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
    void shouldGetCreatedAt() {
        LocalDate now = LocalDate.now();
        UserDTO userDTO = new UserDTO();
        userDTO.setCreatedAt(now);
        Assertions.assertEquals(now, userDTO.getCreatedAt());
    }

    @Test
    void shouldInstantiateUserDTOWithAllArguments() {
        UserDTO userDTO = new UserDTO(null,
                "User Name",
                "email@email.com",
                "123456",
                null);
        Assertions.assertNotNull(userDTO);
    }

}
