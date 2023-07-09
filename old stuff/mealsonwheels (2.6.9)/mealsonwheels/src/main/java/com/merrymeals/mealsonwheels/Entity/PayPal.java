package com.merrymeals.mealsonwheels.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PayPal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentId;
    private String payerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public PayPal() {

    }

    public PayPal(Long id, String paymentId, String payerId) {
        	super();
        	this.id = id;
        	this.paymentId = paymentId;
        	this.payerId = payerId;
    }

    @Override
    public String toString() {
        return "PayPal{" +
                "id=" + id +
                ", paymentId='" + paymentId + '\'' +
                ", payerId='" + payerId + '\'' +
                '}';
    }
}
