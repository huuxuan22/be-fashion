package com.example.projectc1023i1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "category_employee")
public class CategoryEmployee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_employee_id")
    public Integer categoryEmployeeId;
    @Column(name = "ce_name")
    public String ceName;

    @Column(name = "category_name")
    public String categoryName;
}
