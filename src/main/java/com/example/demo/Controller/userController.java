package com.example.demo.Controller;


import com.example.demo.Repository.userRepository;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/useradd")
    public ResponseEntity<?> createUser(@RequestBody Users user) {
        try {
            System.out.println("user is " + user.getPassword());
            userRepository.save(user);
            return new ResponseEntity<Users>(user, HttpStatus.OK);//
        } catch (DataIntegrityViolationException e){
            return new ResponseEntity<>("username exists", HttpStatus.OK);
        }catch (Exception e){
            System.out.println("si " + e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }


}
