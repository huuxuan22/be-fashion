package com.example.projectc1023i1.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class GetTokenFromRequest {
    public static String getTokenFromRequest(HttpServletRequest request) {
        // Kiểm tra token trong cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("JWT".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }

        // Kiểm tra token trong header Authorization (Bearer token)
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);  // Trích xuất token từ "Bearer <token>"
        }

        return null;
    }
}
