package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.entities.Author;
import com.khabalita.springboot.finalseminario.services.AuthorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/authors")
//Clase controladora que extiende de la implementacion de Controller Base, tiene como parametro, la clase Autor
//y la implementacion del servicio autor
public class AuthorController extends BaseControllerImpl<Author, AuthorServiceImpl>{

}
