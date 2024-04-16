package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.dto.request.CategoryRequest;
import com.khabalita.springboot.finalseminario.entities.Category;
import com.khabalita.springboot.finalseminario.mapper.CategoryMapper;
import com.khabalita.springboot.finalseminario.services.CategoryServiceImpl;
import org.apache.coyote.Response;
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
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest categoryRequest){
        try{
            Category category = categoryMapper.categoryRequestToCategory(categoryRequest);
            Category savedCategory = categoryService.save(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error to create a category\"}");
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
}
