package com.example.projectc1023i1.controller.login_register;

import com.example.projectc1023i1.component.JwtTokenUtils;
import com.example.projectc1023i1.model.Users;
import com.example.projectc1023i1.request.LoginRequest;
import com.example.projectc1023i1.respone.ErrorRespones;
import com.example.projectc1023i1.utils.GetTokenFromRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/fashion/")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest loginRequest
    ) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            // Lấy thông tin người dùng từ Authentication object
            Users user = (Users) authentication.getPrincipal();
            String jwt = jwtTokenUtils.generateToken(user);

            redisTemplate.opsForValue().set("TOKEN_" + user.getUsername(), jwt, Duration.ofMinutes(5));
            return ResponseEntity.ok(jwt);

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorRespones("Tài khoản hoặc mật khẩu không đúng.", HttpStatus.UNAUTHORIZED.value()));
        }catch (Exception e) {
            // Xử lý các ngoại lệ khác (nếu có)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã có lỗi xảy ra. Vui lòng thử lại sau.");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String token = GetTokenFromRequest.getTokenFromRequest(request);

        if (token != null) {
            String username = jwtTokenUtils.extractUserName(token);

            // Xóa token khỏi Redis
            redisTemplate.delete("TOKEN_" + username);

            return ResponseEntity.ok("Đăng xuất thành công");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Không tìm thấy token hợp lệ");
        }
    }




}
