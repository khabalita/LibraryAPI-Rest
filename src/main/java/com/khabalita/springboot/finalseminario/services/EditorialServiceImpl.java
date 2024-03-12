package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.entities.Editorial;
import com.khabalita.springboot.finalseminario.repository.BaseRepository;
import com.khabalita.springboot.finalseminario.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServiceImpl extends BaseServiceImpl<Editorial, Long> implements EditorialService{
    @Autowired
    private EditorialRepository editorialRepository;

    //Constructor que trae por parametros la E(editorial) y el ID(long)
    public EditorialServiceImpl(BaseRepository<Editorial, Long> baseRepository){
        //hereda los metodos de Base Service Implements
        super(baseRepository);
    }
}
