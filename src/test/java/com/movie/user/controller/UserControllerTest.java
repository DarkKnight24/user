package com.movie.user.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.movie.base.utils.JsonUtil;
import com.movie.base.utils.MD5Utils;
import com.movie.base.utils.Page;
import com.movie.user.dto.UserLoginDto;
import com.movie.user.param.UserSelectParam;

@SpringBootTest
public class UserControllerTest {
    
    @Autowired
    private UserController userController;
    
    @Test
    public void registry() {
        
        // User user =
        // User.builder().userName("test01").userEmail("1807311502@qq.com").userPwd("123").userRole(UserConstant.ROLE).userHeadImg(UserConstant.DEFAULT_IMAGE).build();
        // userController.registry(user);
        
    }
    
    @Test
    void login() {
        UserLoginDto dto = new UserLoginDto();
        dto.setUserName("huahua");
        dto.setUserPwd("zy5201314.");
        Object login = userController.login(dto);
        System.out.println(JsonUtil.toJson(login));
    }
    
    @Test
    public void test() {
        String s = MD5Utils.MD5("test01123");
        System.out.println(s);
    }
    
    @Test
    void findByParam() {
        UserSelectParam param = new UserSelectParam();
        param.setRole(2);
        Object byParam = userController.findByParam(param, new Page());
        System.out.println(JsonUtil.toJson(byParam));
    }
}
