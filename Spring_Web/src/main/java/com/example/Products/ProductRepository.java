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
        new Product(1L,"Сахар",90.04);
        new Product(2L,"Картофель",28.55);
     new Product(3L,"Гречневая мука",67.78);
       new Product(4L,"Рис длиннозерновой",119.40);
        new Product(5L,"Капуста",18.25);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
    public void addProduct(Product product) {
        products.add(product);
    }

            public void deleteProductById(Long id) {
                products.removeIf(product -> product.getId().equals(id));
            }

            public Product findProductById(Long id) {
                return products.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("product not found"));
            }
        }
