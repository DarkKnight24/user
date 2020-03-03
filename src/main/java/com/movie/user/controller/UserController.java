package com.movie.user.controller;

import com.movie.base.dto.UserBaseDto;
import com.movie.base.interfaces.UserClient;
import com.movie.user.entity.User;
import com.movie.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Mengcc
 */
@RestController
@RequestMapping("user")
@Slf4j
@CrossOrigin
public class UserController implements UserClient {

    @Autowired
    private UserService userService;

    @PostMapping("registry")
    public Object registry(@RequestBody @Valid User user){
        int insert = userService.insert(user);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    @GetMapping("detail/{userId}")
    public UserBaseDto getUserDetail(@PathVariable Long userId) {

        return userService.selectByPrimaryKey(userId);
    }
}
