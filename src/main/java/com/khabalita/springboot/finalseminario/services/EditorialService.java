package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.entities.Editorial;
import com.khabalita.springboot.finalseminario.repository.BaseRepository;
import com.khabalita.springboot.finalseminario.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface EditorialService extends BaseService<Editorial, Long>{

}
