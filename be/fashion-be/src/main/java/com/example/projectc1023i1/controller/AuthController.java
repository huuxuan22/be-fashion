package com.example.projectc1023i1.controller;

import com.example.projectc1023i1.component.GoogleJWTValidator;
import com.example.projectc1023i1.component.JwtTokenUtils;
import com.example.projectc1023i1.model.TokenRequest;
import com.example.projectc1023i1.model.Users;
import com.example.projectc1023i1.repository.impl.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private GoogleJWTValidator googleJWTValidator;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @PostMapping("/google")
    public ResponseEntity<String> authenticateWithGoogle(@RequestBody TokenRequest tokenRequest) {
        try {
            Users users = (Users) googleJWTValidator.extractUserInfo(tokenRequest.getToken());
            boolean isValid = GoogleJWTValidator.validateToken(tokenRequest.getToken());
            if (isValid) {
                // Token hợp lệ, trích xuất thông tin người dùng từ payload
                // Tại đây, bạn có thể trích xuất các thông tin như email, name từ JWT payload
                  Users userExist = userRepository.save(users);
//                String token = Jw
                String token = jwtTokenUtils.generateToken(userExist);
                return ResponseEntity.ok("Token: "+token);
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid token.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error verifying token.");
        }
    }
}
