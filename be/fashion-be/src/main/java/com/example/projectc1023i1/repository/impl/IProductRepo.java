package com.example.projectc1023i1.repository.impl;

import com.example.projectc1023i1.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends JpaRepository<Product, Integer> {
    @Query("select p from Product as p join fetch p.images order by p.createdAt desc")
    Page<Product> getAllProduct(Pageable pageable);
}
