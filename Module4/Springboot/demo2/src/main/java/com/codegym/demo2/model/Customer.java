package com.codegym.demo2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.Id;



@Entity
@Table(name = "customer")
@Data
public class Customer {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}