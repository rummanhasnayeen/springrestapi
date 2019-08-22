package com.spring.restapi.Service;

import com.spring.restapi.Entity.User;
import com.spring.restapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User getUserById(int userId){
        User user = userRepository.findById(userId);
        return user;
    }

    public User updateUserById(int userId, User userDetails){
        User updatedUser = userRepository.findById(userId);

        updatedUser.setFirst_name(userDetails.getFirst_name());
        updatedUser.setLast_name(userDetails.getLast_name());
        updatedUser.setEmail(userDetails.getEmail());
        updatedUser.setPassword(userDetails.getPassword());

        userRepository.save(updatedUser);

        return updatedUser;
    }

    public User deleteById(int userId){
        User user = userRepository.findById(userId);
        userRepository.delete(user);
        return user;
    }
}
