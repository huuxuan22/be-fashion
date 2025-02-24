package com.example.projectc1023i1.service;

import com.example.projectc1023i1.Dto.ImageDTO;
import com.example.projectc1023i1.Dto.ProductDTO;
import com.example.projectc1023i1.Exception.DataNotFoundException;
import com.example.projectc1023i1.model.Categories;
import com.example.projectc1023i1.model.Product;
import com.example.projectc1023i1.model.ProductVariant;
import com.example.projectc1023i1.repository.impl.*;
import com.example.projectc1023i1.service.impl.IProductService;
import com.example.projectc1023i1.service.impl.ISizeService;
import com.example.projectc1023i1.utils.ProductUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo productRepo;
    @Autowired
    private ICategoriesRepo categoriesRepo;
    @Autowired
    private ISizeRepo sizeRepo;
    @Autowired
    private IProductVariantRepo productVariantRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IColorRepo colorRepo;
    @Autowired
    private ProductUtils productUtils;


    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepo.getAllActiveProduct(pageable);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepo.findById(id).get();
    }

    @Override
    @Transactional
    public Product addProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        productRepo.findByProductName(productDTO.getProductName())
                .ifPresent(p -> {throw  new DataNotFoundException("Product with name " + productDTO.getProductName() + " already exists");});
        Optional<Categories> categories = categoriesRepo.findById(productDTO.getCategories());
        product.setCategories(categories.get());
        product.setIsActive(true);
        product.setQuality(productDTO.getSumQuality());
        productRepo.save(product);
        Integer idMaxProduct = productRepo.findIdMax();
        product.setProductId(idMaxProduct);
        List<ProductVariant> productVariantList = new ArrayList<>();
        for (int i = 0; i < productDTO.getMorphologyList().size(); i++) {
            ProductVariant productVariant = ProductVariant.builder()
                    .product(product)
                    .price(productDTO.getMorphologyList().get(i).getPrice())
                    .color(colorRepo.findById(productDTO.getMorphologyList().get(i).getColorId()).get())
                    .size(sizeRepo.findById(productDTO.getMorphologyList().get(i).getSizeId()).get())
                    .stock(productDTO.getMorphologyList().get(i).getStock())
                    .sku(productUtils.getSkuFromProductDTO(
                            productDTO.getCategories(),
                            productDTO.getMorphologyList().get(i).getColorId(),
                            productDTO.getMorphologyList().get(i).getSizeId()
                    ))
                    .build();
            productVariantList.add(productVariant);
        }
        productVariantRepo.saveAll(productVariantList);
        return product;
    }




    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product convertProductDtoToProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public void uploadImage(ImageDTO imageDTO) {

    }
}
