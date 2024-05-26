package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.dto.CategoryDto;
import com.khabalita.springboot.finalseminario.entities.Category;
import com.khabalita.springboot.finalseminario.mapper.CategoryMapper;
import com.khabalita.springboot.finalseminario.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public Category newCategory(CategoryDto categoryDto) throws Exception{
        try{
            Category category = categoryMapper.categoryDtoToCategory(categoryDto);
            Category savedCategory = categoryRepository.save(category);
            return savedCategory;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<CategoryDto> listAllCategories() throws Exception{
        try{
            List<Category> categoryList = categoryRepository.findAll();
            List<CategoryDto> categoryDtoList = new ArrayList<>();
            for(Category category: categoryList){
               categoryDtoList.add(categoryMapper.categoryToCategoryDto(category));
            }
            return categoryDtoList;
        } catch (Exception e) {
            throw new Exception (e.getMessage());
        }
    }

    public CategoryDto updateCateoory(Long id, CategoryDto categoryDto) throws Exception {
        try{
            Category existingCategory = categoryRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de categoria no encontrado" + id));
            existingCategory.setName(categoryDto.getName());
            Category updatedCategory = categoryRepository.save(existingCategory);
            return categoryMapper.categoryToCategoryDto(updatedCategory);
        }catch(Exception e){
            throw new Exception ("No se pudo actualizar la categoria" + e.getMessage());
        }
    }

    public boolean deleteCategory(Long id) throws Exception{
        try{
            if(categoryRepository.existsById(id)){
                categoryRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("ID not found" + id);
            }
        }catch (Exception e){
            throw new Exception ("No se pudo eliminar la categoria" + e.getMessage());
        }
    }

    public CategoryDto findCategoryById(Long id) throws Exception{
        try{
            Category category = categoryRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de categoria no encontrado" + id));
            return categoryMapper.categoryToCategoryDto(category);
        }catch (Exception e){
            throw new Exception("No se pudo traer la categoria" + e.getMessage());
        }
    }
}
