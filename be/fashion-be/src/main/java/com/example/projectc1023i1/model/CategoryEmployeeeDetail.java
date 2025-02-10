package com.example.projectc1023i1.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "category_employee_details")
public class CategoryEmployeeeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ced_id")
    private int cedId;

    @Column(name = "employee_code")
    private String employeeCode;

    @Column(name = "salary")
    private Double salary;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "category_employee_id")
    private CategoryEmployee categoryEmployee;

}
