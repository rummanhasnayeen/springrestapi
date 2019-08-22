package com.spring.restapi.Controller;

import com.spring.restapi.Entity.User;
import com.spring.restapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
//End point for creating a new user
    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return  savedUser;
    }

}
