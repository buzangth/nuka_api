package com.genetics.nuka_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name="products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "product name is required")
    private String name;
    @NotBlank(message = "product description is required")
    private String description;
    @NotBlank(message = "product count is required")
    private int count;

    private double amount;

    private String productCreater;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;


//    private File productImage;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProductCreater() {
        return productCreater;
    }

    public void setProductCreater(String productCreater) {
        this.productCreater = productCreater;
    }
    //    public File getProductImage() {
//        return productImage;
//    }

//    public void setProductImage(File productImage) {
//        this.productImage = productImage;
//    }
}
