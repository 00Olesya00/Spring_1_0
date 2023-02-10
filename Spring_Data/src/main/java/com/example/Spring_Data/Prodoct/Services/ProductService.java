package com.example.Spring_Data.Prodoct.Services;

import com.example.Spring_Data.Prodoct.Specifications.ProductSpecification;
import com.example.Spring_Data.Prodoct.Product;
import com.example.Spring_Data.Prodoct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductSpecification productSpecification;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void changeCostById(Integer productId, Integer delta) {
        productRepository.changeCostById(productId, delta);
    }

    public Page<Product> find(Integer minPrice, Integer maxPrice, String partTitle, Integer page) {
        Specification<Product> specification = Specification.where(null);
        if (minPrice != null) {
            specification = specification.and(productSpecification.costGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            specification = specification.and(productSpecification.costLessOrEqualsThan(maxPrice));
        }
        if (partTitle != null) {
            specification = specification.and(productSpecification.titleLike(partTitle));
        }
        return productRepository.findAll(specification, PageRequest.of(page - 1, 50));
    }


    public Page<Product> moreThanMinCost(Integer minCost, Pageable pageable) {
        return productRepository.findAllByCostGreaterThan(minCost,pageable);
    }

    public  Page<Product>lessThanMaxCost(Integer maxCost,Pageable pageable){
        return productRepository.findAllByCostLessThan(maxCost,pageable);
    }

    public Page<Product>findAllByCostBetween(Integer minCost, Integer maxCost,Pageable pageable){
        return productRepository.findAllByCostBetween(minCost, maxCost,pageable);
    }
}