package com.example.projectc1023i1.service.impl;

import com.example.projectc1023i1.model.Size;

import java.util.List;

public interface ISizeService {
    List<Size> getallSize();
    Size getSizeById(Integer id);
    Size addSize(Size size);
    Size updateSize(Size size);
    Size deleteSize(Integer id);
}
