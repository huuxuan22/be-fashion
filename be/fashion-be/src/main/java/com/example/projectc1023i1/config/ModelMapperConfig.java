package com.example.projectc1023i1.config;
import com.example.projectc1023i1.Dto.CategoriesDTO;
import com.example.projectc1023i1.model.Categories;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public CategoriesDTO convertToCategoriesDTO(Categories categories) {
        return modelMapper().map(categories, CategoriesDTO.class);
    }

}
