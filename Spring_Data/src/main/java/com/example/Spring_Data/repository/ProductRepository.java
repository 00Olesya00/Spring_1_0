package com.example.Spring_Data.repository;

import com.example.Spring_Data.data.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
        @Modifying
        @Query("update Product p set p.cost = p.cost + :cost where p.id= :id")
        void changeCostById(@Param(value = "id") Integer id, @Param(value = "cost") Integer cost);

    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByCostGreaterThan(Integer cost, Pageable pageable);

    Page<Product> findAllByCostLessThan(Integer cost, Pageable pageable);

    Page<Product> findAllByCostBetween(Integer min, Integer max,Pageable pageable);

}