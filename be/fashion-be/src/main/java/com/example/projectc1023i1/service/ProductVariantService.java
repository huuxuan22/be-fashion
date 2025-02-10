package com.example.projectc1023i1.service;

import com.example.projectc1023i1.model.ProductVariant;
import com.example.projectc1023i1.repository.impl.IProductVariantRepo;
import com.example.projectc1023i1.service.impl.IProductVariantService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductVariantService implements IProductVariantService {
    @Autowired
    private IProductVariantRepo productVariantRepo;

    @Override
    public List<ProductVariant> getAllProductVariants() {
        return productVariantRepo.findAll();
    }

    @Override
    public ProductVariant getProductVariant(Integer id) {
        return productVariantRepo.findById(id).get();
    }

    @Override
    public ProductVariant addProductVariant(ProductVariant productVariant) {
        return productVariantRepo.save(productVariant);
    }

    @Override
    public ProductVariant updateProductVariant(ProductVariant productVariant) {
        return productVariantRepo.save(productVariant);
    }

    @Override
    public void deleteProductVariant(Integer id) {
        productVariantRepo.deleteById(id);
    }
}
