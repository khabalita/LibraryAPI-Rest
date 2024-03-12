package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.entities.Category;
import com.khabalita.springboot.finalseminario.repository.BaseRepository;
import com.khabalita.springboot.finalseminario.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService extends BaseService<Category,Long> {

}
