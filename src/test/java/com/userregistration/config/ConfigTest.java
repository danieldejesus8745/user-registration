package com.userregistration.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConfigTest {

    @InjectMocks
    private Config config;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnPasswordEncoder() {
        PasswordEncoder passwordEncoder = config.getPasswordEncoder();
        assertNotNull(passwordEncoder);
    }

}
