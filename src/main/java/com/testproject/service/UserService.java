package com.testproject.service;

import com.testproject.model.User;
import com.testproject.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public List<User> all()
    {
        return userRepository.findAll();

    }

    public User getUserByEmail(String pEmail)
    {
        return userRepository.findByEmail(pEmail);

    }
}
