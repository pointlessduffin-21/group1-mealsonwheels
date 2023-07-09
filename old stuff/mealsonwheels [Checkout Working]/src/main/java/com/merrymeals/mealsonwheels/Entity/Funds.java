package com.merrymeals.mealsonwheels.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Funds {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long f_id;
    private String name;
    private double amount;
    private LocalDateTime dateTime;

    public Funds() {

    }

    public Funds(Long f_id, String name, double amount, LocalDateTime dateTime) {
        super();
        this.f_id = f_id;
        this.name = name;
        this.amount = amount;
        this.dateTime = dateTime;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Funds(String name, double amount, LocalDateTime dateTime) {
        this.name = name;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public Funds(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public Funds(String name) {
        this.name = name;
    }

    public Funds(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateTime.format(formatter);
        return "Funds [f_id=" + f_id + ", name=" + name + ", amount=" + amount + ", date=" + formattedDate + "]";
    }
}
