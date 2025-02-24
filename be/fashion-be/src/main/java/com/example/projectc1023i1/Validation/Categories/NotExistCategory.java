package com.example.projectc1023i1.Validation.Categories;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotExitstCategoryValidator.class)
public @interface NotExistCategory {
    String message() default "*loại thời trang này khong tồn tại ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
