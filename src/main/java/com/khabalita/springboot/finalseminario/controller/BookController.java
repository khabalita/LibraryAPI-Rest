package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.entities.Book;
import com.khabalita.springboot.finalseminario.services.BookServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/books")
public class BookController extends BaseControllerImpl<Book, BookServiceImpl>{

}
