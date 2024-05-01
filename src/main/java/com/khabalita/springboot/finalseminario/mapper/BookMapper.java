package com.khabalita.springboot.finalseminario.mapper;

import com.khabalita.springboot.finalseminario.dto.BookDto;
import com.khabalita.springboot.finalseminario.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Book bookDtoToBook(BookDto bookDto){
        Book book = modelMapper.map(bookDto, Book.class);
        return book;
    }

    public BookDto bookToBookDto(Book book){
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        return bookDto;
    }
}
