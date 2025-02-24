package com.example.projectc1023i1.Validation.product;

import com.example.projectc1023i1.model.Color;
import com.example.projectc1023i1.repository.impl.IColorRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class NotExistColorValidator implements ConstraintValidator<NotExistColor, Integer> {
    @Autowired
    private IColorRepo colorRepo;

    @Override
    public boolean isValid(Integer colorId, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Color> color = colorRepo.findById(colorId);
        if (color.isPresent()) {
            return true;
        }
        return false;
    }
}
