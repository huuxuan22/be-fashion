package com.example.projectc1023i1.Dto;

import com.example.projectc1023i1.Validation.product.NotExistProduct;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageDTO implements Validator {
    @NotNull(message = "Bạn chưa chọn product ")
    @NotExistProduct
    private Integer productId;

    @NotEmpty(message = "Danh sách không được trống ")
    private List<MultipartFile> listImage;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
