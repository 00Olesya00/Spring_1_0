package com.example.Spring_Data.stock;

import com.example.Spring_Data.Prodoct.Converter.ProductConverter;
import com.example.Spring_Data.Prodoct.Dto.ProductDto;
import com.example.Spring_Data.Prodoct.repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
@Data
public class Cart {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private List<ProductDto>all_products;

    @PostConstruct
    public void init() {
        all_products = new ArrayList<>();
    }

    public List<ProductDto> addProductCartById(Integer id) {
        all_products.add(productConverter.entityToDto(productRepository.findById(id).get()));
        return all_products;
    }

    public List<ProductDto> removeProductFromCartById(Integer id) {
        all_products.remove(all_products.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Product not found")));
        return all_products;
    }

    public List<ProductDto> getProducts() {
        return Collections.unmodifiableList(all_products);
    }
}