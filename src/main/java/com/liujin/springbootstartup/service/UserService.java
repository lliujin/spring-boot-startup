package com.liujin.springbootstartup.service;

import com.liujin.springbootstartup.dao.UserRepository;
import com.liujin.springbootstartup.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean login(User user) {
        if(userRepository.findByIdAndPassword(user.getId(), user.getPassword()) != null) {
            return true;
        }
        return false;
    }
}
