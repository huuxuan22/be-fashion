package com.example.projectc1023i1.Validation.employee;

import com.example.projectc1023i1.repository.impl.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
@Valid
public class ExistUsernameUserValidator implements ConstraintValidator<ExistUsernameUser, String> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void initialize(ExistUsernameUser constraintAnnotation) {
        // Không cần thực hiện gì thêm trong trường hợp này
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (username == null || username.isEmpty()) {
            return true;  // Chấp nhận giá trị trống nếu không yêu cầu
        }

        // Kiểm tra xem username đã tồn tại trong cơ sở dữ liệu chưa
        return userRepository.findByUsername(username) == null; // Nếu trả về null, có nghĩa là không tồn tại
    }
}
