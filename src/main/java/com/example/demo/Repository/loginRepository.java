package com.example.demo.Repository;

import com.example.demo.model.Users;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;


@Repository
public interface loginRepository {


    String validateUser (@RequestBody Users user);
}
