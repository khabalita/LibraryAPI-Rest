package com.khabalita.springboot.finalseminario.mapper;

import com.khabalita.springboot.finalseminario.dto.request.CategoryRequest;
import com.khabalita.springboot.finalseminario.dto.response.CategoriesResponse;
import com.khabalita.springboot.finalseminario.dto.response.CategoryResponse;
import com.khabalita.springboot.finalseminario.entities.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryMapper {
    public Category categoryRequestToCategory(CategoryRequest categoryRequest){
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return category;
    }

    public CategoriesResponse categoryToCategoryResponseList(List<Category> categories){
        List<CategoryResponse> categoryResponseList = new ArrayList<>();
        for(Category category: categories){
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setName(category.getName());
            categoryResponseList.add(categoryResponse);
        }
        CategoriesResponse categoriesResponse = new CategoriesResponse();
        categoriesResponse.setCatregories(categoryResponseList);
        return categoriesResponse;
    }
}


