package com.example.projectc1023i1.Dto;

import com.example.projectc1023i1.Validation.employee.ExistEmailUser;
import com.example.projectc1023i1.Validation.employee.ExistNumberphoneUser;
import com.example.projectc1023i1.model.CategoryEmployee;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO implements Validator {
    @JsonProperty("fullName")
    @NotBlank(message = "*Tên không được để trống ")
    private String fullName;

    @JsonProperty("age")
    @NotNull(message = "*Bạn chưa nhập tuổi")
    private Integer age;

    @JsonProperty("gender")
    private Boolean gender;

    @ExistNumberphoneUser(message = "*Số điện thoại này đã tồn tại")
    @NotBlank(message = "*Số điện thoại không được để trống")
    @Pattern(
            regexp = "^(\\+84|0)[1-9][0-9]{8}$",
            message = "Số điện thoại không đúng định dạng. Ví dụ: 0123456789 hoặc +84123456789"
    )
    @JsonProperty("numberphone")
    private String numberphone;

    @JsonProperty("birthday")
    private String birthday;

    @Email(message = "*Không đúng định dạng Email")
    @ExistEmailUser()
    @NotBlank(message = "*Email không được để trống ")
    @JsonProperty("email")
    private String email;

    @JsonProperty("province")
    private String province;

    @JsonProperty("district")
    private String district;

    @JsonProperty("commune")
    private String commune;

    @JsonProperty("notes")
    private String notes;

    @JsonProperty("categoryEmployee")
    @NotNull(message = "*Bạn chưa chọn công viện cho nhân viên")
    private Integer categoryEmployee;


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
