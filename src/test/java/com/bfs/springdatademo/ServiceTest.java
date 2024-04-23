package com.bfs.springdatademo;

import com.bfs.springdatademo.domain.User;
import com.bfs.springdatademo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @InjectMocks
    //the class we want to test, inject all the mock instanse into this object
    UserService userService;

    @Mock
    UserJpaRepo userJpaRepo;

    User newUser;
    Long validID;

    @BeforeEach
    public void setup() {
        newUser = User.builder().name("test").email("test@gmail.com").build();
        validID = new Long(1);
    }

    @Test
    public void testCreateUser(){
        when(userJpaRepo.save(newUser)).thenReturn(newUser);
        User returnedUser = userService.saveOrUpdateUser(newUser);
        assertEquals(newUser,returnedUser);
        assertThrows(IllegalArgumentException.class, () -> userService.saveOrUpdateUser(null));
    }

    @Test
    public void testGetUserById(){
        when(userJpaRepo.findById(validID)).thenReturn(Optional.of(newUser));
        User returnedUser = userService.findUserById(validID);

        assertEquals(newUser,returnedUser);
    }
}
