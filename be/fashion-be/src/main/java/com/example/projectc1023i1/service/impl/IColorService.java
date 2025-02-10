package com.example.projectc1023i1.service.impl;


import com.example.projectc1023i1.model.Color;

import java.util.List;

public interface IColorService {
    List<Color> getColors();
    Color getColor(Integer id);
    Color save(Color color);
    void delete(Integer id);
}
