package com.example.projectc1023i1.repository.impl;

import com.example.projectc1023i1.model.CategoryEmployeeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICEmployeeDetailRepo extends JpaRepository<CategoryEmployeeeDetail,Integer> {
    @Query("select count(*) from CategoryEmployeeeDetail ")
    int getIdMax();

    @Query(value = "select u from category_employee_details u where u.user_id = :param",nativeQuery = true)
    Optional<CategoryEmployeeeDetail> getEmployeeDetails(@Param("param") Integer param);
}
