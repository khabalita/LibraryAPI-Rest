package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.dto.AuthorDto;
import com.khabalita.springboot.finalseminario.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/authors")
public class AuthorController{

    @Autowired
    private AuthorService authorService;

    @PostMapping("/createAuthor")
    public ResponseEntity<?> createAuthor(@RequestBody @Valid AuthorDto authorDto) throws Exception{
        authorService.newAuthor(authorDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getOne/{id}")
    @ResponseBody
    public ResponseEntity<?> getAuthor(@PathVariable Long id) throws Exception{
        AuthorDto authorDto = authorService.findAuthorById(id);
        if(authorDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(authorDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
    }

    @GetMapping("/listAuthors")
    @ResponseBody
    public ResponseEntity<?> getAllAuthors() throws Exception{
        List<AuthorDto> authorDtoList = authorService.listAllAuthors();
        return ResponseEntity.status(HttpStatus.OK).body(authorDtoList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Long id, @RequestBody @Valid AuthorDto authorDto) throws Exception{
            AuthorDto updatedAuthor = authorService.updateAuthor(id, authorDto);
            if(updatedAuthor != null){
                return ResponseEntity.status(HttpStatus.OK).body(updatedAuthor);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Author not found}");
            }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) throws Exception{
        boolean deleted = authorService.deleteAuthor(id);
        if(deleted){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author not found");
        }
    }
}
