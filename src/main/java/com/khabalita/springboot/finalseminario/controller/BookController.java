package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.dto.BookDto;
import com.khabalita.springboot.finalseminario.entities.Book;
import com.khabalita.springboot.finalseminario.mapper.BookMapper;
import com.khabalita.springboot.finalseminario.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/books")
public class BookController extends BaseControllerImpl<Book, BookServiceImpl>{

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private BookMapper bookMapper;

    @PostMapping("/createBook")
    public ResponseEntity<?> createBook(@RequestBody BookDto bookDto){
        try{
            Book book = bookMapper.bookDtoToBook(bookDto);
            Book savedBook = bookService.save(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error to create book\"}");
        }
    }

    @GetMapping("/getOne/{id}")
    @ResponseBody
    public ResponseEntity<?> getBook(@PathVariable Long id){
        try{
            Book book= servicio.findById(id);
            if(book != null ){
                BookDto bookDto = bookMapper.bookToBookDto(book);
                return ResponseEntity.status(HttpStatus.OK).body(bookDto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Book not found}");
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to get one book}");
        }
    }

    @GetMapping("/listBooks")
    @ResponseBody
    public ResponseEntity<?> getAllBooks(){
        try{
            List<Book> books = bookService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(books);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to get books}");
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        try{
            Book bookRequestToUpdate = bookMapper.bookDtoToBook(bookDto);
            Book updatedBook = servicio.update(id, bookRequestToUpdate);
            if(updatedBook != null){
                return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Book not found}");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to update book}");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        try{
            boolean deleted = servicio.delete(id);
            if(deleted){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Book not found}");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to delete book}");
        }
    }
}
