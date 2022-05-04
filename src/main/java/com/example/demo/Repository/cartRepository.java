package com.example.demo.Repository;

import com.example.demo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cartRepository extends JpaRepository<Cart, Integer> {
}
