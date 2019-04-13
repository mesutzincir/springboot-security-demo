package com.testproject.controller;

import com.testproject.model.User;
import com.testproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("user/all")
    public List<User> all()
    {
        return userService.all();

    }

    @GetMapping("user/get-user/{pEmail}")
    public User getUserByEmail(@RequestParam(name="pEmail", value="") String pEmail)
    {
        return userService.getUserByEmail(pEmail);

    }
}
