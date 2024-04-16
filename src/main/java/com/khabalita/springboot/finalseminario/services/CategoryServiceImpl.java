package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.entities.Category;
import com.khabalita.springboot.finalseminario.mapper.AuthorMapper;
import com.khabalita.springboot.finalseminario.repository.BaseRepository;
import com.khabalita.springboot.finalseminario.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long> implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorMapper authorMapper;

    //Constructor que trae por parametros la E(category) y el ID(long)
    public CategoryServiceImpl(BaseRepository<Category, Long> baseRepository){super(baseRepository);}

}
