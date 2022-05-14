package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    //id
    //cartNo
    //userID
    //Total Payment
    //payment type

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "cart_no")
    private String cartNo;

    @Column(name = "user_id")
    private String userID;

    @Column(name = "total_payment")
    private String total_payment;

    @Column(name = "payment_type")
    private String payment_type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCartNo() {
        return cartNo;
    }

    public void setCartNo(String cartNo) {
        this.cartNo = cartNo;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTotal_payment() {
        return total_payment;
    }

    public void setTotal_payment(String total_payment) {
        this.total_payment = total_payment;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }
}
