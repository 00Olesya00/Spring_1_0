package com.example.Spring_Data.Prodoct.Converter;


import com.example.Spring_Data.Prodoct.Dto.ProductDto;
import com.example.Spring_Data.Prodoct.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getCost());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }
}