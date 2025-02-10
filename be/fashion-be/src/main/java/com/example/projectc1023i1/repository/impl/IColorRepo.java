package com.example.projectc1023i1.repository.impl;

import com.example.projectc1023i1.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColorRepo extends JpaRepository<Color, Integer> {
}
