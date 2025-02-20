package com.example.projectc1023i1.service.impl;

import com.example.projectc1023i1.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> getAllProducts(Pageable pageable);
    Product getProductById(Integer id);
    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Integer id);
}
