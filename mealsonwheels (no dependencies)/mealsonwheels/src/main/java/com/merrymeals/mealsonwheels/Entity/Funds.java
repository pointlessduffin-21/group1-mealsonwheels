package com.merrymeals.mealsonwheels.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funds {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long f_id;
    private String name;
    private String amount;
    private String date;

    public Funds() {

    }

    public Funds(Long f_id, String name, String amount, String date) {
        super();
        this.f_id = f_id;
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public Long getF_id() {
        return f_id;
    }

    public void setF_id(Long f_id) {
        this.f_id = f_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String toString() {
    	return "Funds [f_id=" + f_id + ", name=" + name + ", amount=" + amount + ", date=" + date + "]";
    }
}
