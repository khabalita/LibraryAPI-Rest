package com.khabalita.springboot.finalseminario.repository;

import com.khabalita.springboot.finalseminario.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean //notacion para que no sea una clase instanciable
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {

}
