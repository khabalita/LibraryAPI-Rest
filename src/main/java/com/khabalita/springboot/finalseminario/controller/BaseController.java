package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

//Interfaz que tiene como parametros E que extiende de Base y un ID que toma cualquier tipo de dato
public interface BaseController <E extends Base, ID extends Serializable>{
    //el parametro <?> es un comodin, que recibe cualquier parametro objeto
    public ResponseEntity<?> getAll();

    public ResponseEntity<?> getOne(@PathVariable ID Id);

    public ResponseEntity<?> save(@RequestBody E entity);

    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);

    public ResponseEntity<?> delete(@PathVariable ID id);
}
