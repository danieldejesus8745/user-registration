package com.userregistration.controllers;

import com.userregistration.dto.UserDTO;
import com.userregistration.entities.User;
import com.userregistration.services.UserService;
import com.userregistration.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(Messages.USER_CREATED.getDescription());
    }

    @GetMapping(path = "/{email}/{password}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("email") String email,
                                           @PathVariable("password") String password) {
        UserDTO response = userService.getUser(email, password);

        if (Objects.isNull(response)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
