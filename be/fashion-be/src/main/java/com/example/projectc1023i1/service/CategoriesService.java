package com.example.projectc1023i1.service;

import com.example.projectc1023i1.Dto.CategoriesDTO;
import com.example.projectc1023i1.Exception.DataNotFoundException;
import com.example.projectc1023i1.model.Categories;
import com.example.projectc1023i1.repository.impl.ICategoriesRepo;
import com.example.projectc1023i1.service.impl.ICategoriesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService implements ICategoriesService {
    @Autowired
    private ICategoriesRepo categoriesRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<Categories> findAll() {
        return categoriesRepo.findAll();
    }

    @Override
    public Categories save(Categories categories) {
        return categoriesRepo.save(categories);
    }

    @Override
    public void delete(Categories categories) {
        categoriesRepo.delete(categories);
    }

    @Override
    public Optional<Categories> findById(Integer id) {
        Categories categories = categoriesRepo.findById(id).orElseThrow(() -> new DataNotFoundException("không tìm thấy loại sản phẩm"));
        return categoriesRepo.findById(id);
    }

    @Override
    public Categories findByName(String name) {
        return null;
    }

    @Override
    public Categories convertToCategories(CategoriesDTO categoriesDTO) {
        return modelMapper.map(categoriesDTO, Categories.class);
    }
}
