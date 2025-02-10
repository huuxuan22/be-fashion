package com.example.projectc1023i1.respone.errorsValidate;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriesErrorsRespone {
    private String categoriesName;
    private String description;
    private String categoriesCode;
}
