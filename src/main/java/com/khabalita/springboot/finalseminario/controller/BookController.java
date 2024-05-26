package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.dto.BookDto;
import com.khabalita.springboot.finalseminario.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/books")
public class BookController{

    @Autowired
    private BookService bookService;

    @PostMapping("/createBook")
    public ResponseEntity<?> createBook(@RequestBody @Valid BookDto bookDto) throws Exception{
        bookService.newBook(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getOne/{id}")
    @ResponseBody
    public ResponseEntity<?> getBook(@PathVariable Long id) throws Exception{
        BookDto bookDto = bookService.findBookById(id);
        if(bookDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(bookDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
    }

    @GetMapping("/listBooks")
    @ResponseBody
    public ResponseEntity<?> getAllBooks() throws Exception{
        List<BookDto> bookDtoList = bookService.listAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(bookDtoList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody @Valid BookDto bookDto) throws Exception{
        BookDto updatedBook = bookService.updateBook(id, bookDto);
        if(updatedBook != null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Book not found}");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) throws Exception{
        boolean deleted = bookService.deleteBook(id);
        if(deleted){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }
}
