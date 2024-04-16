package com.khabalita.springboot.finalseminario.mapper;

import com.khabalita.springboot.finalseminario.dto.request.AuthorRequest;
import com.khabalita.springboot.finalseminario.dto.response.AuthorResponse;
import com.khabalita.springboot.finalseminario.dto.response.AuthorsResponse;
import com.khabalita.springboot.finalseminario.entities.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorMapper{

    public Author authorRequestToAuthor(AuthorRequest authorRequest){
        Author author = new Author();
        author.setName(authorRequest.getName());
        author.setLastName(authorRequest.getLastName());
        author.setNationality(authorRequest.getNationality());
        author.setBirthdate(authorRequest.getBirthdate());
        author.setDeathdate(authorRequest.getDeathdate());
        author.setBiography(authorRequest.getBiography());
        return author;
    }

    public AuthorsResponse authorToAuthorResponseList(List<Author> authors){
        List<AuthorResponse> authorResponseList = new ArrayList<>();
        for(Author author: authors){
            AuthorResponse authorResponse = new AuthorResponse();
            authorResponse.setName(author.getName());
            authorResponse.setLastName(author.getLastName());
            authorResponse.setNationality(author.getNationality());
            authorResponse.setBirthdate(author.getBirthdate());
            authorResponse.setDeathdate(author.getDeathdate());
            authorResponse.setBiography(author.getBiography());
            authorResponseList.add(authorResponse);
        }
        AuthorsResponse authorsResponse = new AuthorsResponse();
        authorsResponse.setAuthors(authorResponseList);
        return authorsResponse;
    }

    public AuthorResponse authorToAuthorResponse(Author author) {
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setName(author.getName());
        authorResponse.setLastName(author.getLastName());
        authorResponse.setNationality(author.getNationality());
        authorResponse.setBirthdate(author.getBirthdate());
        authorResponse.setDeathdate(author.getDeathdate());
        authorResponse.setBiography(author.getBiography());
        return authorResponse;
    }
}
