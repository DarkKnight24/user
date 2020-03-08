package com.movie.user.controller;

import com.movie.base.interfaces.UserClient;
import com.movie.user.dto.UserLoginDto;
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
    @ResponseBody
    public Object registry(@RequestBody @Valid User user) {
        int insert = userService.insert(user);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @PostMapping("login")
    @ResponseBody
    public Object login(@RequestBody UserLoginDto userLoginDto) {
        return userService.login(userLoginDto);
    }

    @Override
    @GetMapping("detail/{userId}")
    @ResponseBody
    public Object getUserDetail(@PathVariable Long userId) {

        return userService.selectByPrimaryKey(userId);
    }

    @PostMapping("upload")
    @ResponseBody
    public Object uploadUser(@RequestBody User user){
        User recode = userService.updateByPrimaryKey(user);
        return recode==null?false:recode;
    }
}
