package com.example.projectc1023i1.respone;

import com.example.projectc1023i1.model.CategoryEmployeeeDetail;
import com.example.projectc1023i1.model.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRespone {
    private String imgUrl;
    private int age;
    private Boolean gender;
    private String numberphone;
    private String fullName;
    private String address;
    private String birthday;
    private String username;
    private String email;
    private Boolean isActive;
    private LocalDateTime createAt;
    private Roles role;
}
