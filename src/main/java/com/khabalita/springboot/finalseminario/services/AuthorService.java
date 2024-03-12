package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.entities.Author;
import org.springframework.stereotype.Service;

//Interfaz que extiende de BaseService y le paso por parametro la clase y el tipo de dato, clase corresponde a E y Long al ID
@Service
public interface AuthorService extends BaseService<Author,Long>{

}
