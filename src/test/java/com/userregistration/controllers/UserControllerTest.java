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
import org.springframework.http.ResponseEntity;

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

}
