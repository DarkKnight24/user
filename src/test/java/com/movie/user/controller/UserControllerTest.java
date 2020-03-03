package com.movie.user.controller;


import com.movie.base.constant.UserConstant;
import com.movie.base.utils.MD5Utils;
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

        User user = User.builder().userName("test01").userEmail("1807311502@qq.com").userPwd("123").userRole(UserConstant.ROLE).userHeadImg(UserConstant.DEFAULT_IMAGE).build();
        userController.registry(user);

    }

    @Test
    public void test() {
        String s = MD5Utils.MD5("test01123");
        System.out.println(s);
    }
}
