package com.example.projectc1023i1.controller.admin;

import com.example.projectc1023i1.Dto.ImageDTO;
import com.example.projectc1023i1.Dto.ProductDTO;
import com.example.projectc1023i1.model.Product;
import com.example.projectc1023i1.model.Users;
import com.example.projectc1023i1.respone.errorsValidate.ProductErrorsRespone;
import com.example.projectc1023i1.service.ProductService;
import com.example.projectc1023i1.service.impl.IProductService;
import com.example.projectc1023i1.utils.ProductUtils;
import jakarta.validation.Valid;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/admin/product/")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private View error;
    @Autowired
    private ProductUtils  productUtils;

    @GetMapping("get-all-product")
    public ResponseEntity<?> getAllProduct(@AuthenticationPrincipal Users user
                                            , @RequestParam("size") int size
                                            , @RequestParam("page") int page) {
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Người dùng đang bị null hoặc chưa đăng nhập");
        }
        if (size <= 0 || page <= 0) {
            size = 10;
            page = 0;
        }
        Pageable pageable =  PageRequest.of(page,size);
        Page<Product> page1 = productService.getAllProducts( pageable);
        return ResponseEntity.ok(page1);
    }

    @PostMapping("add-product")
    public ResponseEntity<?> addProduct( @AuthenticationPrincipal Users user,
                                         @Valid @RequestBody ProductDTO productDTO,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ProductErrorsRespone productErrorsRespone = new ProductErrorsRespone();
            StringBuilder morphologyErrors = new StringBuilder();
            bindingResult.getFieldErrors().stream()
                    .forEach(error -> {
                        String field = error.getField();
                        String message = error.getDefaultMessage();
                        switch (field) {
                            case "productId":
                                productErrorsRespone.setProductId(message);
                                break;
                            case "productName":
                                productErrorsRespone.setProductName(message);
                                break;
                            case "description":
                                productErrorsRespone.setDescription(message);
                                break;
                            case "categories":
                                productErrorsRespone.setCategories(message);
                                break;

                            default:
                                if (field.startsWith("morphologyList")) {
                                    morphologyErrors.append(message).append(" , ");
                                }
                                break;
                        }
                    });
                // Nếu có lỗi trong morphologyList, loại bỏ dấu `, ` cuối cùng
                if (morphologyErrors.length() > 0) {
                    productErrorsRespone.setMorphologyList(morphologyErrors.substring(0, morphologyErrors.length() - 2));
                }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productErrorsRespone);
        }
        Product product = productService.addProduct(productDTO);
        return ResponseEntity.ok("Add product successfully");
    }


    @PostMapping( value = "upload-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadImage(
                @AuthenticationPrincipal Users users,
                @Valid @ModelAttribute ImageDTO imageDTO,
                BindingResult bindingResult
    ) throws IOException {
        if (bindingResult.hasErrors()) {

        }
        for (MultipartFile file : imageDTO.getListImage()) {
            if (file.getSize() == 0) {
                continue;
            }
            if (file.getSize() > 1024 * 1024) {
                return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("anh qua lon, lon hon 10Byte");
            }
            String contentType = file.getContentType();
            if (contentType == null || !contentType.contains("image/")) {
                return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("unsupported image type");
            }
            String fileName = productUtils.storeFile(file);
        }
        return null;
    }

    @GetMapping("/images/{imageName}")
    public ResponseEntity<?> getImage(@PathVariable String imageName) {
        try {
            Path imagePath = Paths.get("uploads/product/"+imageName);
            UrlResource resource = new UrlResource(imagePath.toUri());
            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resource);
            }else {
                return ResponseEntity.notFound().build();
            }
        }catch ( Exception e ) {
                return ResponseEntity.notFound().build();
        }
    }


}
