package com.example.demo.Repository;

import com.example.demo.model.Cart;
import com.example.demo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface paymentRepository extends JpaRepository<Payment, Integer> {
}
