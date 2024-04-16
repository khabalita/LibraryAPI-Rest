package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.dto.request.AuthorRequest;
import com.khabalita.springboot.finalseminario.dto.response.AuthorResponse;
import com.khabalita.springboot.finalseminario.entities.Author;
import com.khabalita.springboot.finalseminario.mapper.AuthorMapper;
import com.khabalita.springboot.finalseminario.services.AuthorServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/authors")
//Clase controladora que extiende de la implementacion de Controller Base, tiene como parametro, la clase Autor
//y la implementacion del servicio autor
public class AuthorController extends BaseControllerImpl<Author, AuthorServiceImpl>{

    @Autowired
    private AuthorServiceImpl authorService;

    @Autowired
    private AuthorMapper authorMapper;

    @PostMapping("/createAuthor")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorRequest authorRequest) {
        try {
            Author author = authorMapper.authorRequestToAuthor(authorRequest);
            Author savedAuthor = authorService.save(author);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAuthor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error to create author\"}");
        }
    }

    @GetMapping("/listAuthors")
    @ResponseBody
    public ResponseEntity<?> getAllAuthors(){
        try{
            List<Author> authors = authorService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(authors);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to get authors}");
        }

    }
}
