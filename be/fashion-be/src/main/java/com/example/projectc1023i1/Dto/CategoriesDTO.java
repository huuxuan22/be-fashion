package com.example.projectc1023i1.Dto;

import com.example.projectc1023i1.Validation.Categories.ExistCategoriesCodeWithName;
import com.example.projectc1023i1.Validation.Categories.ExistCategoriesName;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriesDTO implements Validator {
    @NotBlank(message = "bạn chưa điền tên loại sản phẩm ")
    @ExistCategoriesCodeWithName
    @ExistCategoriesName
    private String categoryName;

    @NotBlank(message = "bạn chưa điền mô tả ")
    private String description;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    @Override
    public Errors validateObject(Object target) {
        return Validator.super.validateObject(target);
    }
}
