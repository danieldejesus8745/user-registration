package com.userregistration.services;

import com.userregistration.dto.UserDTO;
import com.userregistration.entities.User;
import com.userregistration.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void addUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreatedAt(LocalDate.now());
        userRepository.save(user);
    }

    public UserDTO getUser(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);

        if (Objects.isNull(user)) {
            return null;
        }

        if (!password.equals(user.getPassword())) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUuid(user.getUuid());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }

}
