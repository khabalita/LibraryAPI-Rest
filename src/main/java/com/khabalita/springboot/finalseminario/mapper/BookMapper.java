package com.khabalita.springboot.finalseminario.mapper;

import com.khabalita.springboot.finalseminario.dto.AuthorDto;
import com.khabalita.springboot.finalseminario.dto.BookDto;
import com.khabalita.springboot.finalseminario.dto.CategoryDto;
import com.khabalita.springboot.finalseminario.dto.EditorialDto;
import com.khabalita.springboot.finalseminario.entities.Author;
import com.khabalita.springboot.finalseminario.entities.Book;
import com.khabalita.springboot.finalseminario.entities.Category;
import com.khabalita.springboot.finalseminario.entities.Editorial;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Book bookDtoToBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        if (bookDto.getAuthorDto() != null) {
            Author author = modelMapper.map(bookDto.getAuthorDto(), Author.class);
            book.setAuthor(author);
        }
        if (bookDto.getEditorialDto() != null) {
            Editorial editorial = modelMapper.map(bookDto.getEditorialDto(), Editorial.class);
            book.setEditorial(editorial);
        }
        if (bookDto.getCategoryDto() != null) {
            List<Category> categories = bookDto.getCategoryDto().stream()
                    .map(categoryDto -> modelMapper.map(categoryDto, Category.class))
                    .collect(Collectors.toList());
            book.setCategory(categories);
        }
        return book;
    }

    public BookDto bookToBookDto(Book book) {
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        if (book.getAuthor() != null) {
            AuthorDto authorDto = modelMapper.map(book.getAuthor(), AuthorDto.class);
            bookDto.setAuthorDto(authorDto);
        }
        if (book.getEditorial() != null) {
            EditorialDto editorialDto = modelMapper.map(book.getEditorial(), EditorialDto.class);
            bookDto.setEditorialDto(editorialDto);
        }
        if (book.getCategory() != null) {
            List<CategoryDto> categories = book.getCategory().stream()
                    .map(category -> modelMapper.map(category, CategoryDto.class))
                    .collect(Collectors.toList());
            bookDto.setCategoryDto(categories);
        }
        return bookDto;
    }
}
