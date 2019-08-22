package com.spring.restapi.Controller;

import com.spring.restapi.Entity.User;
import com.spring.restapi.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(value="User", description="User profile REST api end-points with description")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "End point for creating a new user")
    @PostMapping("/user")
    public User saveUser(@Valid @RequestBody User user){
        User savedUser = userService.saveUser(user);
        return  savedUser;
    }

    @ApiOperation(value = "Retrieving a user profile information with the user id")
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable(value = "id") int userId){
        User user = userService.getUserById(userId);
        return user;
    }

    //update a user
    @ApiOperation(value = "Updating a user profile information with the user id")
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable(value = "id") int userId, @Valid @RequestBody User user){
        User updatedUser = userService.updateUserById(userId, user);
        return updatedUser;
    }

    //delete a user
    @ApiOperation(value = "Deleting a user profile information with the user id")
    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable(value = "id") int userId){
        User user = userService.deleteById(userId);
        return user;
    }
}
