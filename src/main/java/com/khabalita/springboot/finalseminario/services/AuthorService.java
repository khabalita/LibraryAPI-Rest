package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.dto.AuthorDto;
import com.khabalita.springboot.finalseminario.entities.Author;
import com.khabalita.springboot.finalseminario.mapper.AuthorMapper;
import com.khabalita.springboot.finalseminario.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public Author newAuthor(AuthorDto authorDto) throws Exception{
        try{
            Author author = authorMapper.authorDtoToAuthor(authorDto);
            Author savedAuthor = authorRepository.save(author);
            return savedAuthor;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<AuthorDto> listAllAuthors() throws Exception{
        try{
            List<Author> authorList = authorRepository.findAll();
            List<AuthorDto> authorDtoList = new ArrayList<>();
            for(Author author: authorList){
                authorDtoList.add(authorMapper.authorToAuthorDto(author));
            }
            return authorDtoList;
        } catch (Exception e) {
            throw new Exception (e.getMessage());
        }
    }

    public AuthorDto updateAuthor(Long id, AuthorDto authorDto) throws Exception {
        try{
            Author existingAuthor = authorRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de author no encontrado" + id));
            existingAuthor.setName(authorDto.getName());
            existingAuthor.setLastName(authorDto.getLastName());
            existingAuthor.setNationality(authorDto.getNationality());
            existingAuthor.setBirthdate(authorDto.getBirthdate());
            existingAuthor.setDeathdate(authorDto.getDeathdate());
            existingAuthor.setBiography(authorDto.getBiography());
            Author updatedAuthor = authorRepository.save(existingAuthor);
            return authorMapper.authorToAuthorDto(updatedAuthor);
        }catch(Exception e){
            throw new Exception ("No se pudo actualizar la marca" + e.getMessage());
        }
    }

    public boolean deleteAuthor(Long id) throws Exception{
        try{
            if(authorRepository.existsById(id)){
                authorRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("ID not found" + id);
            }
        }catch (Exception e){
            throw new Exception ("No se pudo eliminar el autor" + e.getMessage());
        }
    }

    public AuthorDto findAuthorById(Long id) throws Exception{
        try{
            Author author = authorRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de autor no encontrado" + id));
            return authorMapper.authorToAuthorDto(author);
        }catch (Exception e){
            throw new Exception("No se pudo traer el autor" + e.getMessage());
        }
    }

}
