package com.example.projectc1023i1.Validation.Categories;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistCategoriesCodeWithNameValidator.class)
public @interface ExistCategoriesCodeWithName {
    String message() default "mã code theo tên categies này đã tồn tại (Ví dụ TTN: thời trang nữ TTN Thời trang nam )";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
