package com.example.projectc1023i1.controller;

import com.example.projectc1023i1.Dto.CategoriesDTO;
import com.example.projectc1023i1.model.Categories;
import com.example.projectc1023i1.respone.errorsValidate.CategoriesErrorsRespone;
import com.example.projectc1023i1.service.impl.ICategoriesService;
import com.example.projectc1023i1.utils.GetFirstString;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.Optional;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {
    @Autowired
    private ICategoriesService categoriesService;
    @Autowired
    private View error;

    /**
     *
     * @return tra ve tat ca danh sach category
     */
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok(categoriesService.findAll());
    }

    /**
     *
     * @param categoriesDTO lop category validtate
     * @param bindingResult lop validate tra ve ket qua
     * @param request
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<?> createCategories(@Valid @RequestBody CategoriesDTO categoriesDTO,
                                              BindingResult bindingResult,
                                              HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            CategoriesErrorsRespone combinedErrors = new CategoriesErrorsRespone();
            bindingResult.getFieldErrors().forEach(fieldError -> {
               String errorMessage = fieldError.getDefaultMessage();
               switch (fieldError.getField()) {
                       case "categoryName":
                           combinedErrors.setCategoriesName(
                                   (combinedErrors.getCategoriesName()!= null ?
                                           combinedErrors.getCategoriesName() + "," : "") + errorMessage);
                            break;
                        case "categoryCode":
                            combinedErrors.setCategoriesCode(
                                    (combinedErrors.getCategoriesCode() != null ?
                                            combinedErrors.getCategoriesCode() + "," : "") + errorMessage
                            );
                            break;
                        case "description":
                            combinedErrors.setDescription(
                                    (combinedErrors.getDescription() != null ?
                                            combinedErrors.getDescription() + "," : "") + errorMessage
                            );
               }
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(combinedErrors);
        }
        Categories categories = new Categories();
        categories.setCategoriesCode(GetFirstString.getFirstString(categoriesDTO.getCategoryName()));
        categories.setCategoriesName(categoriesDTO.getCategoryName());
        categories.setDescription(categoriesDTO.getDescription());
        categoriesService.save(categoriesService.save(categories));
        return ResponseEntity.ok(categoriesDTO);
    }

    /**
     *
     * @param id id cua categry
     * @return tra ve 404 de khong tim thay
     *          tra ve 400 neu khong tim thay san pham
     */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCategories(@PathVariable Integer id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không thấy id");
        }
        Optional<Categories> categories = categoriesService.findById(id);
        if (categories.isPresent()) {
            categoriesService.delete(categories.get());
            return ResponseEntity.ok("đã xóa thành công loại sản phẩm :" + categories.get().getCategoriesName());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Không tìm thấy sản phẩm");
    }

    /**
     *
     * @param id id cua category
     * @return loi 404 neu khong tim thay id cua  category
     *          loi 400 neu khong tim thay san pham
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategories(@PathVariable Integer id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("không tìm thấy Id");
        }
        Optional<Categories> categories = categoriesService.findById(id);
        if (categories.isPresent()) {
            return ResponseEntity.ok(categories.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("không tìm thấy loại sản phẩm ");
    }

    /**
     *
     * @param id id cua category
     * @param categoriesDTO lop category dung de lam validate
     * @param bindingResult lop kiem tra validate tra ve ket qua
     * @return
     *          tra ve 404 neu khong tim thay
     *          tra ve 400 neu validate cua categoriesDTO bi loi
     *          tra ve 200 neu them moi thanh cong 1 category
     */
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateCategories(@PathVariable Integer id,
                                              @Valid @RequestBody CategoriesDTO categoriesDTO,
                                              BindingResult bindingResult) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id này không tồn tại");
        }
        if (bindingResult.hasErrors()) {
            CategoriesErrorsRespone combinedErrors = new CategoriesErrorsRespone();
            bindingResult.getFieldErrors().forEach(fieldError -> {
                String errorMessage = fieldError.getDefaultMessage();
                switch (fieldError.getField()) {
                    case "categoryName":
                        combinedErrors.setCategoriesName(
                                (combinedErrors.getCategoriesName()!= null ?
                                        combinedErrors.getCategoriesName() + "," : "") + errorMessage);
                        break;
                    case "categoryCode":
                        combinedErrors.setCategoriesCode(
                                (combinedErrors.getCategoriesCode() != null ?
                                        combinedErrors.getCategoriesCode() + "," : "") + errorMessage
                        );
                        break;
                    case "description":
                        combinedErrors.setDescription(
                                (combinedErrors.getDescription() != null ?
                                        combinedErrors.getDescription() + "," : "") + errorMessage
                        );
                }
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(combinedErrors);
        }
        Categories categories = new Categories();
        categories.setCategoriesCode(GetFirstString.getFirstString(categoriesDTO.getCategoryName()));
        categories.setCategoriesName(categoriesDTO.getCategoryName());
        categories.setDescription(categoriesDTO.getDescription());
        categoriesService.save(categoriesService.save(categories));
        return ResponseEntity.ok(categoriesDTO);

    }


}
