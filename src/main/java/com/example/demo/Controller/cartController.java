package com.example.demo.Controller;


import com.example.demo.Repository.cartRepository;
import com.example.demo.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1")
@RestController
public class cartController {

    @Autowired
    private cartRepository cartRepository;

    @GetMapping("/getCartData")
    public List<Cart> getAllCartData() {
        return cartRepository.findAll();
    }

    @GetMapping("/check3")
    public String Check2() {
        return "checking cart dockarization";
    }


    @PostMapping("/cartadd")
    public ResponseEntity<?> addCartData(@RequestBody Cart cart) {
        try {
            cartRepository.save(cart);
            return new ResponseEntity<>(cart, HttpStatus.OK);//
        }catch (Exception e){
            System.out.println("si " + e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/updatecart/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") int id, @RequestBody Cart cart){
        Optional<Cart> cartUpdate = Optional.ofNullable(cartRepository.getById(id));
        if(cartUpdate.isPresent()){
            Cart updateCart = cartUpdate.get();
            //updateUser.setId(user.getId()  != 0 ? user.getId() : updateUser.getId());
            updateCart.setCartNo(cart.getCartNo() != null ? cart.getCartNo() : updateCart.getCartNo());
            updateCart.setUserID(cart.getUserID() != null ? cart.getUserID() : updateCart.getUserID());
            updateCart.setItemID(cart.getItemID() != null ? cart.getItemID() : updateCart.getItemID());
            updateCart.setItem_count(cart.getItem_count() != 0 ? cart.getItem_count() : updateCart.getItem_count());
            Cart value = cartRepository.save(updateCart);
            //System.out.println("hi " + updateUser);
            return new ResponseEntity<>(value, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Cart Data Available", HttpStatus.NOT_FOUND);
        }
    }

    //Delete user
    @DeleteMapping("/deleteCart/{id}")
    public ResponseEntity<?> deleteCart(@PathVariable("id") int id){
        cartRepository.deleteById(id);
        return new ResponseEntity<>("delete successful", HttpStatus.OK);
    }

    @DeleteMapping("/deleteCartItem/{id}")
    public ResponseEntity<?> deleteCartItem(@PathVariable("id") int id){
//        cartRepository.deleteById(id);
        return new ResponseEntity<>("delete successful", HttpStatus.OK);
    }
}
