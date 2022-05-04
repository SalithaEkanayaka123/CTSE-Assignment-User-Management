package com.example.demo.Controller;


import com.example.demo.Repository.userRepository;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") int id, @RequestBody Users user){
        Optional<Users> userUpdate = Optional.ofNullable(userRepository.getById(id));
        System.out.println("user updated " + userUpdate.isPresent());
        if(userUpdate.isPresent()){
            Users updateUser = userUpdate.get();
            //updateUser.setId(user.getId()  != 0 ? user.getId() : updateUser.getId());
            updateUser.setName(user.getName() != null ? user.getName() : updateUser.getName());
            updateUser.setEmail(user.getEmail() != null ? user.getEmail() : updateUser.getEmail());
            updateUser.setAge(user.getAge() != 0 ? user.getAge() : updateUser.getAge());
            updateUser.setUsername(user.getUsername() != null ? user.getUsername() : updateUser.getUsername());
            updateUser.setPassword(user.getPassword() != null ? user.getPassword() : updateUser.getPassword());
            Users value = userRepository.save(updateUser);
            //System.out.println("hi " + updateUser);
            return new ResponseEntity<>(value, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No User Available", HttpStatus.NOT_FOUND);
        }
    }

    //Delete user
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
        userRepository.deleteById(id);
        return new ResponseEntity<>("delete successful", HttpStatus.OK);
    }


}
