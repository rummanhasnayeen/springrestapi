package com.spring.restapi.Controller;

import com.spring.restapi.Entity.User;
import com.spring.restapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //End point for creating a new user
    @PostMapping("/user")
    public User saveUser(@Valid @RequestBody User user){
        User savedUser = userService.saveUser(user);
        return  savedUser;
    }

    //getting a user
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable(value = "id") int userId){
        User user = userService.getUserById(userId);
        return user;
    }

    //update a user
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable(value = "id") int userId, @Valid @RequestBody User user){
        User updatedUser = userService.updateUserById(userId, user);
        return updatedUser;
    }

    //delete a user
    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable(value = "id") int userId){
        User user = userService.deleteById(userId);
        return user;
    }
}
