package com.example.projectc1023i1.service;

import com.example.projectc1023i1.model.CategoryEmployeeeDetail;
import com.example.projectc1023i1.repository.impl.ICEmployeeDetailRepo;
import com.example.projectc1023i1.service.impl.ICEmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CEmployeeDetailService implements ICEmployeeDetailService {

    @Autowired
    protected ICEmployeeDetailRepo employeeDetailRepo;
    @Autowired
    private ICEmployeeDetailRepo icEmployeeDetailRepo;
    @Override
    public void saveCED(CategoryEmployeeeDetail categoryEmployeeeDetail) {
        employeeDetailRepo.save(categoryEmployeeeDetail);
    }

    @Override
    public int getIdMax() {
        return employeeDetailRepo.getIdMax()+1;
    }

    @Override
    public Optional<CategoryEmployeeeDetail> getCEDById(Integer id) {
        return employeeDetailRepo.getEmployeeDetails(id);
    }


}
