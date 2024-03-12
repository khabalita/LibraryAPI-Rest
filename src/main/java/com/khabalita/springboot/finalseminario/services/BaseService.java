package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.entities.Base;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

//Interfaz que tiene como parametro E que extiende de Base del paquete modelo, y ID que puede tomar cualquier tipo de dato
@Service
public interface BaseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception;

    public E findById(ID id) throws Exception;

    public E save(E entity) throws Exception;

    public E update(ID id, E entity) throws Exception;

    public Boolean delete(ID id) throws Exception;
}
