package com.example.projectc1023i1.Validation.product;

import com.example.projectc1023i1.model.Product;
import com.example.projectc1023i1.repository.impl.IProductRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductExistValidator implements ConstraintValidator<ProductExist, String> {

    @Autowired
    private IProductRepo productRepo;
    @Override
    public boolean isValid(String productName, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Product> product = productRepo.findByProductName(productName);
        if (product.isPresent()) {
            return false;
        }
        return true;
    }
}
