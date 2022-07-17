package com.userregistration.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MessagesTest {

    @Test
    void shouldReturnMessage() {
        String result = Messages.USER_CREATED.getDescription();
        Assertions.assertEquals(Messages.USER_CREATED.getDescription(), result);
    }

}
