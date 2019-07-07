package com.sda.parkingManagement.controller;

import com.sda.parkingManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    public UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
