package com.khabalita.springboot.finalseminario.repository;

import com.khabalita.springboot.finalseminario.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
