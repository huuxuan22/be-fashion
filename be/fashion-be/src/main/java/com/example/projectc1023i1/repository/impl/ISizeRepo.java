package com.example.projectc1023i1.repository.impl;

import com.example.projectc1023i1.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISizeRepo extends JpaRepository<Size, Integer> {
}
