package com.oldman.springbootmultidatasource.controller;

import com.oldman.springbootmultidatasource.domain.User;
import com.oldman.springbootmultidatasource.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author oldman
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("userOne")
    public List<User> findAllByUserOne(){
        return userServiceImpl.findAllByUserOne();
    }

    @GetMapping("userTwo")
    public List<User> findAllByUserTwo(){
        return userServiceImpl.findAllByUserTwo();
    }
}
