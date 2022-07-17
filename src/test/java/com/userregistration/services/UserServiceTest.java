package com.userregistration.services;

import com.userregistration.dto.UserDTO;
import com.userregistration.entities.User;
import com.userregistration.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldAddUser() {
        UserDTO userDTO = new UserDTO();
        userService.addUser(userDTO);
        verify(userRepository, times(1)).save(any());
    }

    @Test
    void shouldGetUser() {
        userService.getUser("", "");
        verify(userRepository, times(1)).findByEmail(any());
    }

    @Test
    void passwordsShouldBeDifferent() {
        String password = "12345";
        User user = new User();
        user.setPassword(password);
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(user));
        UserDTO resultTest = userService.getUser("", "123456");
        Assertions.assertNull(resultTest);
    }

    @Test
    void shouldGetUserDTO() {
        String password = "123456";
        User user = new User();
        user.setPassword(password);
        when(userRepository.findByEmail(any())).thenReturn(Optional.of(user));
        UserDTO resultTest = userService.getUser("", password);
        Assertions.assertNotNull(resultTest);
    }

}
