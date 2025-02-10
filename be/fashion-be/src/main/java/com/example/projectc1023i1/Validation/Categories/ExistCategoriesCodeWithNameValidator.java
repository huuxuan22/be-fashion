package com.example.projectc1023i1.Validation.Categories;

import com.example.projectc1023i1.repository.impl.ICategoriesRepo;
import com.example.projectc1023i1.utils.GetFirstString;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ExistCategoriesCodeWithNameValidator implements ConstraintValidator<ExistCategoriesCodeWithName, String> {

    @Autowired
    private ICategoriesRepo categoriesRepo;

    @Override
    public void initialize(ExistCategoriesCodeWithName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Boolean flag  = false;
        if (categoriesRepo == null) {
            return false;
        }else if (!categoriesRepo.existsByCategoriesCode(GetFirstString.getFirstString(s))) {
            return true;
        }
        return false;
    }
}
