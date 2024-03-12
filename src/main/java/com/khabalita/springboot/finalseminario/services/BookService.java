package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.entities.Book;
import com.khabalita.springboot.finalseminario.repository.BaseRepository;
import com.khabalita.springboot.finalseminario.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface BookService extends BaseService<Book, Long>{

}
