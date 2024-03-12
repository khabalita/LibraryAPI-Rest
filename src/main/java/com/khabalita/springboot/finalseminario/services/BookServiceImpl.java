package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.entities.Book;
import com.khabalita.springboot.finalseminario.repository.BaseRepository;
import com.khabalita.springboot.finalseminario.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book, Long> implements BookService{
    @Autowired
    private BookRepository bookRepository;

    //Constructor que traer por parametros la E(book) y el ID(long)
    public BookServiceImpl(BaseRepository<Book,Long> baseRepository){
        //hereda los metodos de Base Service Implements
        super(baseRepository);
    }
}
