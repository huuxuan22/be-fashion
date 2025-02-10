package com.example.projectc1023i1.repository.impl;

import com.example.projectc1023i1.model.AddressUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressUserRepo extends JpaRepository<AddressUser, Integer> {
    @Query("select u from  AddressUser u where u.user.userId = :param")
    AddressUser findByUser(@Param("param") Integer param);
}
