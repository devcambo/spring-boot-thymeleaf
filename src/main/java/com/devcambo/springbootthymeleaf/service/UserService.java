package com.devcambo.springbootthymeleaf.service;

import com.devcambo.springbootthymeleaf.model.User;
import com.devcambo.springbootthymeleaf.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepo.save(user);
        return savedUser.getUserId() > 0;
    }

}
