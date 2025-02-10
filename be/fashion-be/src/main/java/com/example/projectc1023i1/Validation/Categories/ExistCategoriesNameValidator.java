package com.example.projectc1023i1.Validation.Categories;


import com.example.projectc1023i1.repository.impl.ICategoriesRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ExistCategoriesNameValidator implements ConstraintValidator<ExistCategoriesName, String> {
    @Autowired
    private ICategoriesRepo categoriesRepo;
    @Override
    public void initialize(ExistCategoriesName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (categoriesRepo == null) {
            return true;
        } else if (!categoriesRepo.existsByCategoriesName(s)) {
            return true;
        }
        return false;
    }
}
