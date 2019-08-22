package com.spring.restapi.service;

import com.spring.restapi.Entity.User;
import com.spring.restapi.Repository.UserRepository;
import com.spring.restapi.Service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void saveUserTest(){
        User user = new User();

        user.setId(3);
        user.setFirst_name("Yeasir");
        user.setLast_name("Afsar");
        user.setEmail("yeasir@gmail.com");
        user.setPassword("124578");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.saveUser(user);

        verify(userRepository, times(1)).save(user);
        Assert.assertEquals(savedUser, user);
    }

    @Test
    public void getUserByIdTest(){
        User user = new User();

        user.setId(3);
        user.setFirst_name("Yeasir");
        user.setLast_name("Afsar");
        user.setEmail("yeasir@gmail.com");
        user.setPassword("124578");

        when(userRepository.findById(anyInt())).thenReturn(user);

        User getUser = userService.getUserById(3);

        verify(userRepository, times(1)).findById(3);
        Assert.assertEquals(getUser, user);
    }

    @Test
    public void updateUserByIdTest(){
        User user = new User();

        user.setId(3);
        user.setFirst_name("Yeasir");
        user.setLast_name("Afsar");
        user.setEmail("yeasir@gmail.com");
        user.setPassword("124578");

        when(userRepository.findById(anyInt())).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);

        User updatedUser = userService.updateUserById(3, user);

        verify(userRepository, times(1)).findById(3);
        verify(userRepository, times(1)).save(user);
        Assert.assertEquals(updatedUser, user);
    }

    @Test
    public void deleteByIdTest(){
        User user = new User();

        user.setId(3);
        user.setFirst_name("Yeasir");
        user.setLast_name("Afsar");
        user.setEmail("yeasir@gmail.com");
        user.setPassword("124578");

        when(userRepository.findById(anyInt())).thenReturn(user);

        User deletedUser = userService.deleteById(3);

        verify(userRepository,times(1)).findById(3);
        verify(userRepository,times(1)).delete(user);

        Assert.assertEquals(deletedUser, user);
    }

}
