package com.example.projectc1023i1.service;

import com.example.projectc1023i1.model.Product;
import com.example.projectc1023i1.repository.impl.IProductRepo;
import com.example.projectc1023i1.service.impl.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepo.getAllProduct(pageable);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }
}
