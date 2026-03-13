package com.irq3;

import com.irq3.domain.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUser {

    @Test
    public void testHashing(){
        User user = User.create("test","email@test.gm","test123");
        user.hashPassword();
        Assertions.assertTrue(user.checkPassword("test123"));
    }
}
