package com.khabalita.springboot.finalseminario.repository;

import com.khabalita.springboot.finalseminario.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
