package com.example.projectc1023i1.Validation.employee;

import com.example.projectc1023i1.repository.impl.IUserRepository;
import com.example.projectc1023i1.service.impl.IUserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ExistNumberPhoneValidator implements ConstraintValidator<ExistNumberphoneUser, String> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void initialize(ExistNumberphoneUser constraintAnnotation) {
        // Bạn có thể để trống hoặc thêm bất kỳ logic khởi tạo nào nếu cần
    }

    @Override
    public boolean isValid(String numberPhone, ConstraintValidatorContext context) {
        // Kiểm tra xem số điện thoại đã tồn tại trong cơ sở dữ liệu chưa
        if (numberPhone == null || numberPhone.isEmpty()) {
            return false; // Trả về false nếu số điện thoại rỗng
        }

        // Nếu số điện thoại đã tồn tại trong cơ sở dữ liệu thì không hợp lệ
        boolean exists = userRepository.findByNumberphone(numberPhone).isPresent();
        return !exists;  // Nếu tồn tại, trả về false (không hợp lệ), nếu không tồn tại, trả về true (hợp lệ)
    }
}

