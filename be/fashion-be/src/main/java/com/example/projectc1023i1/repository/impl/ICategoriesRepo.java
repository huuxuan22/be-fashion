package com.example.projectc1023i1.repository.impl;

import com.example.projectc1023i1.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICategoriesRepo extends JpaRepository<Categories,Integer> {
    Categories findByCategoriesCode(String categoriesCode);

    Boolean existsByCategoriesCode( String categoriesCode);

    Boolean existsByCategoriesName( String categoriesName);
}
