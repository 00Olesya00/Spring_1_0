package com.example.Products;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(Arrays.asList());
        new Product(1,"Сахар",90.04);
        new Product(2,"Картофель",28.55);
        new Product(3,"Гречневая мука",67.78);
        new Product(4,"Рис длиннозерновой",119.40);
        new Product(5,"Капуста",18.25);
    }

    public Product findById(int id){
            return products.stream().filter(p -> p.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("Продукт отсутствует"));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);

    }
}
