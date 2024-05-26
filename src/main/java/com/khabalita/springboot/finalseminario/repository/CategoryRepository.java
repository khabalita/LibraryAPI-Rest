package com.khabalita.springboot.finalseminario.repository;

import com.khabalita.springboot.finalseminario.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
