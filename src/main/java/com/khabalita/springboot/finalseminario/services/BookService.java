package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.dto.BookDto;
import com.khabalita.springboot.finalseminario.entities.Author;
import com.khabalita.springboot.finalseminario.entities.Book;
import com.khabalita.springboot.finalseminario.entities.Category;
import com.khabalita.springboot.finalseminario.entities.Editorial;
import com.khabalita.springboot.finalseminario.mapper.AuthorMapper;
import com.khabalita.springboot.finalseminario.mapper.BookMapper;
import com.khabalita.springboot.finalseminario.mapper.CategoryMapper;
import com.khabalita.springboot.finalseminario.mapper.EditorialMapper;
import com.khabalita.springboot.finalseminario.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookService{
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private EditorialRepository editorialRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private EditorialMapper editorialMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    public Book newBook(BookDto bookDto) throws Exception{
        try{
            Book book = bookMapper.bookDtoToBook(bookDto);
            if (book.getAuthor() != null) {
                Author savedAuthor = authorRepository.save(book.getAuthor());
                book.setAuthor(savedAuthor);
            }

            if (book.getEditorial() != null) {
                Editorial savedEditorial = editorialRepository.save(book.getEditorial());
                book.setEditorial(savedEditorial);
            }

            if (book.getCategory() != null && !book.getCategory().isEmpty()) {
                List<Category> savedCategories = book.getCategory().stream()
                        .map(categoryRepository::save)
                        .collect(Collectors.toList());
                book.setCategory(savedCategories);
            }

            return bookRepository.save(book);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public List<BookDto> listAllBooks() throws Exception {
        try{
            List<Book> bookList = bookRepository.findAll();
            List<BookDto> bookDtoList = new ArrayList<>();
            for(Book book: bookList){
                bookDtoList.add(bookMapper.bookToBookDto(book));
            }
            return bookDtoList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public BookDto updateBook(Long id, BookDto bookDto) throws Exception {
        try {
            // Encuentra el libro existente
            Book existingBook = bookRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de libro no encontrado: " + id));

            // Actualiza los campos básicos
            existingBook.setISBN(bookDto.getISBN());
            existingBook.setTitle(bookDto.getTitle());
            existingBook.setSubTitle(bookDto.getSubTitle());
            existingBook.setEdition(bookDto.getEdition());

            // Actualiza el autor si está presente en el DTO
            if (bookDto.getAuthorDto() != null) {
                Author author = authorMapper.authorDtoToAuthor(bookDto.getAuthorDto());
                existingBook.setAuthor(author);
            }

            // Actualiza la editorial si está presente en el DTO
            if (bookDto.getEditorialDto() != null) {
                Editorial editorial = editorialMapper.editorialDtoToEditorial(bookDto.getEditorialDto());
                existingBook.setEditorial(editorial);
            }

            // Actualiza las categorías si están presentes en el DTO
            if (bookDto.getCategoryDto() != null && !bookDto.getCategoryDto().isEmpty()) {
                List<Category> categories = bookDto.getCategoryDto().stream().map(categoryDto -> {
                    Category category = new Category();
                    category.setId(categoryDto.getId());
                    category.setName(categoryDto.getName());
                    return category;
                }).collect(Collectors.toList());
                existingBook.setCategory(categories);
            }

            // Guarda el libro actualizado
            Book updatedBook = bookRepository.save(existingBook);

            // Devuelve el libro actualizado como un DTO
            return bookMapper.bookToBookDto(updatedBook);

        } catch (Exception e) {
            throw new Exception("No se pudo actualizar el libro: " + e.getMessage());
        }
    }

    public boolean deleteBook(Long id) throws Exception{
        try{
            if(bookRepository.existsById(id)){
                bookRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("ID not found" + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public BookDto findBookById(Long id) throws Exception{
        try{
            Book book = bookRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de libro no encontrado" + id));
            return bookMapper.bookToBookDto(book);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
