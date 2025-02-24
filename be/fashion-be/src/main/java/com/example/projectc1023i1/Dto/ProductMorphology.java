package com.example.projectc1023i1.Dto;

import com.example.projectc1023i1.Validation.product.NotExistColor;
import com.example.projectc1023i1.Validation.product.NotExistSize;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductMorphology implements Validator {
    @NotNull(message = "Mã màu không được để trống")
    @NotExistColor
    private Integer colorId;

    @NotNull(message = "Mã size không được để trống")
    @NotExistSize
    private Integer sizeId;

    @NotNull(message = "Giá không được để trống")
    @Positive(message = "Giá phải lớn hơn 0")
    private Double price;

    @NotNull(message = "Số lượng không được để trống")
    @Positive(message = "Số lượng phải lớn hơn 0")
    private Integer stock;

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductMorphology.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductMorphology morphology = (ProductMorphology) target;

        // Có thể thêm các logic kiểm tra thêm nếu cần
        if (morphology.getPrice() != null && morphology.getPrice() < 0) {
            errors.rejectValue("price", "price.negative", "Giá không thể nhỏ hơn 0");
        }
    }


}
