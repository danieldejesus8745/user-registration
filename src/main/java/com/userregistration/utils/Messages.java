package com.userregistration.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Messages {

    USER_CREATED("Usuário adicionado com sucesso");

    private final String description;

}
