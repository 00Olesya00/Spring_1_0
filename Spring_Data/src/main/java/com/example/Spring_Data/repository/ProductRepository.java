package com.example.Spring_Data.repository;

import com.example.Spring_Data.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query(value = "update Product p set p.cost = p.cost + :price where p.id= :id")
    void changeCostById(@Param(value = "id") Long id, @Param(value = "price") Integer cost);

    List<Product> findAllByCostGreaterThan(Integer cost);

    List<Product> findAllByCostLessThan(Integer cost);

    List<Product> findAllByCostBetween(Integer min, Integer max);
}