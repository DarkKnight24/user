package com.movie.user.controller;

import com.movie.user.entity.User;
import com.movie.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("registry")
    public Object registry(User user){
        int insert = userService.insert(user);
        if(insert>0){
            return true;
        }
        return false;
    }
}
