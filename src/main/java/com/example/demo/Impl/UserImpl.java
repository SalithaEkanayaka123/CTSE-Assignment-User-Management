package com.example.demo.Impl;

import com.example.demo.Repository.loginRepository;
import com.example.demo.Repository.userRepository;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements loginRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String validateUser(Users user) {
        String sql = "SELECT username FROM users WHERE username=? AND password=?";
        try {
            String username = jdbcTemplate.queryForObject(sql, new Object[] {
                    user.getUsername(), user.getPassword() }, String.class);
            System.out.println(username);
            return username;
        } catch (Exception e) {
            return null;
        }
    }
}
