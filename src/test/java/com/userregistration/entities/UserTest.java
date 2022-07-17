package com.userregistration.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldGetUuid() {
        User user = new User();
        user.setUuid(UUID.randomUUID());
        Assertions.assertNotNull(user.getUuid());
    }

    @Test
    void shouldGetName() {
        User user = new User();
        user.setName("User Name");
        Assertions.assertNotNull(user.getName());
    }

    @Test
    void shouldGetEmail() {
        User user = new User();
        user.setEmail("email@email.com");
        Assertions.assertNotNull(user.getEmail());
    }

    @Test
    void shouldGetPassword() {
        User user = new User();
        user.setPassword("123456");
        Assertions.assertNotNull(user.getPassword());
    }

    @Test
    void shouldGetCreatedAt() {
        User user = new User();
        user.setCreatedAt(LocalDate.now());
        Assertions.assertNotNull(user.getCreatedAt());
    }

    @Test
    void ShouldBeInstantiateWithAllArguments() {
        User user = new User(UUID.randomUUID(),
                "username",
                "email@email.com",
                "123456",
                LocalDate.now());
        Assertions.assertNotNull(user);
    }

}
