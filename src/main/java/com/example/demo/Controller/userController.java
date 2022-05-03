package com.example.demo.Controller;


import com.example.demo.Repository.userRepository;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/api/v1")
@RestController
public class userController {

    @Autowired
    private userRepository userRepository;

    @GetMapping("/getUsers")
    public List<Users> getAllEmployees() {
        return userRepository.findAll();
    }
}
