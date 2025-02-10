package com.example.projectc1023i1.service.impl;

import com.example.projectc1023i1.model.ProductVariant;

import java.util.List;

public interface IProductVariantService {
    List<ProductVariant> getAllProductVariants();
    ProductVariant getProductVariant(Integer id);
    ProductVariant addProductVariant(ProductVariant productVariant);
    ProductVariant updateProductVariant(ProductVariant productVariant);
    void deleteProductVariant(Integer id);
}
