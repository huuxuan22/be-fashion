package com.example.projectc1023i1.service.impl;

import com.example.projectc1023i1.Dto.CategoriesDTO;
import com.example.projectc1023i1.model.Categories;

import java.util.List;
import java.util.Optional;

public interface ICategoriesService {
    List<Categories> findAll();
    Categories save(Categories categories);
    void delete(Categories categories);
    Optional<Categories> findById(Integer id);
    Categories findByName(String name);
    Categories convertToCategories(CategoriesDTO categoriesDTO);
}
