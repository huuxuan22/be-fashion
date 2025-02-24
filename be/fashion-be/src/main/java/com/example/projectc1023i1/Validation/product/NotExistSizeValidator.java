package com.example.projectc1023i1.Validation.product;


import com.example.projectc1023i1.model.Size;
import com.example.projectc1023i1.repository.impl.ISizeRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class NotExistSizeValidator implements ConstraintValidator<NotExistSize, Integer> {
    @Autowired
    private ISizeRepo sizeRepo;
    @Override
    public boolean isValid(Integer idSize, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Size> size = sizeRepo.findById(idSize);
        if (size.isPresent()) {
            return true;
        }
        return false;
    }
}
