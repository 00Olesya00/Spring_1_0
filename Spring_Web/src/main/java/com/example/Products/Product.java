package com.example.Products;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Product {
    private Long id;
    private String title;
    private double cost;



}


