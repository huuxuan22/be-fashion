package com.example.projectc1023i1.service.impl;

import com.example.projectc1023i1.model.CategoryEmployee;

import java.util.List;

public interface ICategoryEmployeeService {
    List<CategoryEmployee> getAllCategoriesEmployee();
    CategoryEmployee getCategoryEmployeeById(int id);
}
