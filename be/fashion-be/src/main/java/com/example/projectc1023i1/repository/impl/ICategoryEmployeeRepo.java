package com.example.projectc1023i1.repository.impl;

import com.example.projectc1023i1.model.CategoryEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ICategoryEmployeeRepo extends JpaRepository<CategoryEmployee, Integer> {

}
