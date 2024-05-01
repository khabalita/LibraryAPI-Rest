package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.dto.AuthorDto;
import com.khabalita.springboot.finalseminario.entities.Author;
import com.khabalita.springboot.finalseminario.mapper.AuthorMapper;
import com.khabalita.springboot.finalseminario.services.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> createAuthor(@RequestBody AuthorDto authorDto) {
        try {
            Author author = authorMapper.authorDtoToAuthor(authorDto);
            Author savedAuthor = authorService.save(author);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedAuthor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error to create author\"}");
        }
    }

    @GetMapping("/getOne/{id}")
    @ResponseBody
    public ResponseEntity<?> getAuthor(@PathVariable Long id){
        try{
            Author author= servicio.findById(id);
            if(author != null ){
                AuthorDto authorDto = authorMapper.authorToAuthorDto(author);
                return ResponseEntity.status(HttpStatus.OK).body(authorDto);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Author not found}");
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to get one author}");
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

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto){
        try{
            Author authorRequestToUpdate = authorMapper.authorDtoToAuthor(authorDto);
            Author updatedAuthor = servicio.update(id, authorRequestToUpdate);
            if(updatedAuthor != null){
                return ResponseEntity.status(HttpStatus.OK).body(updatedAuthor);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Author not found}");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to update author}");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id){
        try{
            boolean deleted = servicio.delete(id);
            if(deleted){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Author not found}");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to delete author}");
        }
    }
}
