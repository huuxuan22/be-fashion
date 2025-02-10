package com.example.projectc1023i1.Validation.employee;

import com.example.projectc1023i1.repository.impl.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ExistEmailUserValidator implements ConstraintValidator<ExistEmailUser, String> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void initialize(ExistEmailUser constraintAnnotation) {
        // Không cần xử lý gì ở đây nếu không có yêu cầu đặc biệt
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        // Kiểm tra xem email đã tồn tại trong cơ sở dữ liệu hay chưa
        if (email == null || email.isEmpty()) {
            return true; // Trả về true nếu email rỗng hoặc null (không có lỗi gì)
        }

        // Kiểm tra xem email có tồn tại trong cơ sở dữ liệu
        boolean exists = userRepository.findByEmail(email).isPresent();

        // Nếu email tồn tại, trả về false (không hợp lệ), nếu không tồn tại trả về true (hợp lệ)
        return !exists;
    }
}
