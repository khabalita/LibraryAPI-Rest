package com.khabalita.springboot.finalseminario.mapper;

import com.khabalita.springboot.finalseminario.dto.CategoryDto;
import com.khabalita.springboot.finalseminario.entities.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryMapper {
    @Autowired
    private ModelMapper modelMapper;

    //mapea de un request a una entity
    public Category categoryDtoToCategory(CategoryDto categoryDto){
        Category category = modelMapper.map(categoryDto, Category.class);
        return category;
    }

    public CategoryDto categoryToCategoryDto(Category category){
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }
}


