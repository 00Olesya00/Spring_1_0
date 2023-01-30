package com.example.Spring_Data.Dto;

import com.example.Spring_Data.data.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private Integer id;

    private String title;

    private Integer cost;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.cost = product.getCost();
    }
}