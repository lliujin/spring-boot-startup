package com.liujin.springbootstartup.dao;

import com.liujin.springbootstartup.SpringBootStartupApplicationTests;
import com.liujin.springbootstartup.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserRepositoryTest extends SpringBootStartupApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindByIdAndPassword() {
        User user = userRepository.findByIdAndPassword(2L, "12345");
        System.out.println(user);
    }
}