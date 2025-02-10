package com.example.projectc1023i1.service.impl;

import com.example.projectc1023i1.model.CategoryEmployeeeDetail;

import java.util.Optional;

public interface ICEmployeeDetailService {
    void saveCED(CategoryEmployeeeDetail categoryEmployeeeDetail);
    int getIdMax();
    Optional<CategoryEmployeeeDetail> getCEDById(Integer id);
}
