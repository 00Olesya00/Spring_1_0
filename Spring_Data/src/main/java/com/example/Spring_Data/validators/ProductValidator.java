package com.example.Spring_Data.validators;

import com.example.Spring_Data.Dto.ProductDto;
import com.example.Spring_Data.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {
    public void validate (ProductDto productDto) {
        List<String> errors = new ArrayList<>();
        if (productDto.getCost() <= 0) {
            errors.add("Product price can't be zero or lower");
        }
        if (productDto.getTitle().isBlank()) {
            errors.add("Product name can't be blank");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
