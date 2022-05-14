package com.example.demo.Controller;


import com.example.demo.Repository.cartRepository;
import com.example.demo.Repository.paymentRepository;
import com.example.demo.model.Cart;
import com.example.demo.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class paymentController {

    @Autowired
    private paymentRepository paymentRepository;

    @GetMapping("/getPaymentData")
    public List<Payment> getAllPaymentData() {
        return paymentRepository.findAll();
    }

    @PostMapping("/paymentadd")
    public ResponseEntity<?> addPaymentData(@RequestBody Payment payment) {
        try {
            paymentRepository.save(payment);
            return new ResponseEntity<>(payment, HttpStatus.OK);//
        }catch (Exception e){
            System.out.println("si " + e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

}
