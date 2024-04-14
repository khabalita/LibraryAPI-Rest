package com.khabalita.springboot.finalseminario.repository;

import com.khabalita.springboot.finalseminario.entities.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {
}
