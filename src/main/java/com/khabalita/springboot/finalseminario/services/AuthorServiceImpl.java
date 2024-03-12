package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.entities.Author;
import com.khabalita.springboot.finalseminario.repository.AuthorRepository;
import com.khabalita.springboot.finalseminario.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Clase de implementacion que extiende de la clase BaseService implememntada, con los parametros del Autor
//a su vez implementa el AutorService
@Service
public class AuthorServiceImpl extends BaseServiceImpl<Author, Long> implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(BaseRepository<Author, Long> baseRepository){
        super(baseRepository);
    }
}
