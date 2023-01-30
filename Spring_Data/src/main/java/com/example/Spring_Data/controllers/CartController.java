package com.example.Spring_Data.controllers;

import com.example.Spring_Data.Dto.ProductDto;
import com.example.Spring_Data.stock.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/carts")
public class CartController {
    private final Cart cart;

    @GetMapping()
    public List<ProductDto> showCart() {
        return cart.getProducts();
    }

    @GetMapping("/add")
    public List<ProductDto> addProductToCart(@RequestParam Integer productId) {
        return cart.addProductCartById(productId);
    }

    @GetMapping("/remove/{productId}")
    public List<ProductDto> removeProductFromCart(@PathVariable Integer productId) {
        return cart.removeProductFromCartById(productId);
    }

}