package com.example.projectc1023i1.Validation.product;

import com.example.projectc1023i1.repository.impl.IProductRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NotExistProductValidator implements ConstraintValidator<NotExistProduct, Integer> {
    @Autowired
    private IProductRepo productRepo;

    @Override
    public void initialize(NotExistProduct constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer productId, ConstraintValidatorContext constraintValidatorContext) {
        if (productRepo.findById(productId).isPresent()) {
            return true;
        }
        return false;
    }
}
