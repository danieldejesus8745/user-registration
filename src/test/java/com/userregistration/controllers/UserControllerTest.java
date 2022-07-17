package com.userregistration.controllers;

import com.userregistration.dto.UserDTO;
import com.userregistration.services.UserService;
import com.userregistration.utils.Messages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldAddUser() {
        UserDTO userDTO = new UserDTO();
        ResponseEntity<String> result = userController.addUser(userDTO);
        Assertions.assertEquals(Messages.USER_CREATED.getDescription(), result.getBody());
    }

    @Test
    void shouldGetUser() {
        UserDTO userDTO = new UserDTO();
        when(userService.getUser(any(), any())).thenReturn(userDTO);
        ResponseEntity<UserDTO> resultTest = userController.getUser("", "");
        Assertions.assertNotNull(resultTest);
        verify(userService, times(1)).getUser(any(), any());
    }

    @Test
    void credentialsShouldBeInvalid() {
        ResponseEntity<UserDTO> resultTest = userController.getUser("", "");
        Assertions.assertEquals(resultTest.getStatusCode(), HttpStatus.UNAUTHORIZED);
    }

}
