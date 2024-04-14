package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.entities.Category;
import com.khabalita.springboot.finalseminario.services.CategoryServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/categories")
public class CategoryController extends BaseControllerImpl<Category, CategoryServiceImpl>{

}
