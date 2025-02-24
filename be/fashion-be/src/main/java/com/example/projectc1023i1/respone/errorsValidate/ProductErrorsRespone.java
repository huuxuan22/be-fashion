package com.example.projectc1023i1.respone.errorsValidate;

import com.example.projectc1023i1.Validation.product.ProductExist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductErrorsRespone {
    private String productId;
    private String productName;
    private String description;
    private String categories;
    private String morphologyList;
}
