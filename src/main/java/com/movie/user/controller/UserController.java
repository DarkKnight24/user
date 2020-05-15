package com.movie.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.movie.base.interfaces.UserClient;
import com.movie.base.utils.Page;
import com.movie.user.dto.UserLoginDto;
import com.movie.user.entity.User;
import com.movie.user.param.UserSelectParam;
import com.movie.user.service.UserService;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Mengcc
 */
@RestController
@RequestMapping("user")
@Slf4j
@CrossOrigin
@Api(tags = "用户服务")
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
    public Object uploadUser(@RequestBody User user) {
        User recode = userService.updateByPrimaryKey(user);
        return recode == null ? false : recode;
    }
    
    @GetMapping("all")
    @ResponseBody
    public Object findByParam(UserSelectParam param, Page page) {
        return userService.findByParam(param, page);
    }
}
