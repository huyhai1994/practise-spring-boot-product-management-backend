package com.codegym.practisesmartphonemanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private BigInteger quantity;
    private String color;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
