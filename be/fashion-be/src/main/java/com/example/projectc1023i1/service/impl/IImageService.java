package com.example.projectc1023i1.service.impl;

import com.example.projectc1023i1.model.Image;

import java.util.List;

public interface IImageService {
    List<Image> getAllImagesById(Integer id);
    Image getImageById(Integer id);

}
