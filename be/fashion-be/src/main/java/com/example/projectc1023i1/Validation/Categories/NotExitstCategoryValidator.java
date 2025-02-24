package com.example.projectc1023i1.Validation.Categories;

import com.example.projectc1023i1.repository.impl.ICategoriesRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class NotExitstCategoryValidator implements ConstraintValidator<NotExistCategory, Integer> {
    @Autowired
    private ICategoriesRepo categoriesRepo;

    @Override
    public void initialize(NotExistCategory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (categoriesRepo.existsById(integer)) {
            return true;
        }
        return false;
    }
}
