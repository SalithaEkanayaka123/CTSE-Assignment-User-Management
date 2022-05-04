package com.example.demo.Repository;

import com.example.demo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface cartRepository extends JpaRepository<Cart, Integer> {
}
