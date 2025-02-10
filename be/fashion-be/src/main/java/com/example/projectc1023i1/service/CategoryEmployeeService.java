package com.example.projectc1023i1.service;

import com.example.projectc1023i1.model.CategoryEmployee;
import com.example.projectc1023i1.repository.impl.ICategoryEmployeeRepo;
import com.example.projectc1023i1.service.impl.ICategoryEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryEmployeeService implements ICategoryEmployeeService {
    @Autowired
    private ICategoryEmployeeRepo categoryEmployeeRepo;

    @Override
    public List<CategoryEmployee> getAllCategoriesEmployee() {
        return categoryEmployeeRepo.findAll();
    }

    @Override
    public CategoryEmployee getCategoryEmployeeById(int id) {
        return categoryEmployeeRepo.findById(id).get();
    }
}
