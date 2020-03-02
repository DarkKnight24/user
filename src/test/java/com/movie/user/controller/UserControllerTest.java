package com.movie.user.controller;


import com.movie.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;
    @Test
    public void registry() {

        User user = User.builder().userName("花花").userEmail("123").userPwd("321").build();
        userController.registry(user);

    }
}