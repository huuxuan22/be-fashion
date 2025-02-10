package com.example.projectc1023i1.service;

import com.example.projectc1023i1.model.Color;
import com.example.projectc1023i1.repository.impl.IColorRepo;
import com.example.projectc1023i1.service.impl.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService implements IColorService {
    @Autowired
    private IColorRepo colorRepository;

    @Override
    public List<Color> getColors() {
        return colorRepository.findAll();
    }

    @Override
    public Color getColor(Integer id) {
        return colorRepository.findById(id).get();
    }

    @Override
    public Color save(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public void delete(Integer id) {
        colorRepository.deleteById(id);
    }
}
