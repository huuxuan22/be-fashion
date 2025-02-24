package com.example.projectc1023i1.repository.impl;

import com.example.projectc1023i1.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepo extends JpaRepository<Product, Integer> {


    @Query("select p from Product as p where p.isActive = true order by p.createdAt desc ")
    public Page<Product> getAllActiveProduct(Pageable pageable);

    @Query("select p from Product as p where p.productName = :param")
    Optional<Product> findByProductName(@Param("param") String productName);

    @Modifying
    @Query("update Product as p set p.isActive = false where p.productId = :param")
    void deleteProduct(@Param("param") Integer productId);

    @Query("select max(p.productId) from Product as p")
    Integer findIdMax();







}
