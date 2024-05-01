package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.dto.CategoryDto;
import com.khabalita.springboot.finalseminario.entities.Category;
import com.khabalita.springboot.finalseminario.mapper.CategoryMapper;
import com.khabalita.springboot.finalseminario.services.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/categories")
public class CategoryController extends BaseControllerImpl<Category, CategoryServiceImpl>{

    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private CategoryMapper categoryMapper;

    @PostMapping("/createCategory")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto){
        try{
            Category category = categoryMapper.categoryDtoToCategory(categoryDto);
            Category savedCategory = categoryService.save(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error to create a category\"}");
        }
    }

    @GetMapping("/getOne/{id}")
    @ResponseBody
    public ResponseEntity<?> getCategory(@PathVariable Long id){
        try{
            Category category = servicio.findById(id);
            if(category != null){
                CategoryDto categoryDto = categoryMapper.categoryToCategoryDto(category);
                return ResponseEntity.status(HttpStatus.OK).body(categoryDto);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Category not found}");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to get one Category}");
        }

    }

    @GetMapping("/listCategories")
    @ResponseBody
    public ResponseEntity<?> getAllCategories(){
        try{
            List<Category> categories = categoryService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(categories);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error to get categories\"}");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto){
        try{
            Category categoryDtoToUpdate = categoryMapper.categoryDtoToCategory(categoryDto);
            Category updatedCategory = servicio.update(id, categoryDtoToUpdate);
            if(updatedCategory != null){
                return ResponseEntity.status(HttpStatus.OK).body(updatedCategory);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Category not found}");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to update category}");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        try{
            boolean deleted = servicio.delete(id);
            if(deleted){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Category not found}");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to delete category}");
        }
    }

}
