//package com.example.projectc1023i1.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:3000")  // Địa chỉ frontend của bạn
//                .allowedMethods("GET", "POST", "PUT", "DELETE","PATCH")
//                .allowedHeaders("*")
//                .allowCredentials(true);
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/uploads/**")
//                .addResourceLocations("file:D:/ptran-fashion/ptran-fashion-backend/ptran-fashion-be/project-C1023I1/uploads/employee/");
//    }
//}
