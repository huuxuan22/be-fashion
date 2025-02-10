package com.example.projectc1023i1.respone.errorsValidate;

import com.example.projectc1023i1.Validation.employee.ExistEmailUser;
import com.example.projectc1023i1.Validation.employee.ExistNumberphoneUser;
import com.example.projectc1023i1.model.CategoryEmployee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeErrorsRespone {
    private String fullName;
    private String imgUrl;
    private String age;
    private String gender;
    private String numberphone;
    private String birthday;
    private String email;
}
