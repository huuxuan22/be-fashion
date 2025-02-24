package com.example.projectc1023i1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categorieId;

    @Column(name = "categories_name")
    private String categoriesName;

    @Column(name = "description")
    private String description;

    @Column(name = "categories_code")
    private String categoriesCode;
}
