package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.entities.Editorial;
import com.khabalita.springboot.finalseminario.services.EditorialServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/editorials")
public class EditorialController extends BaseControllerImpl<Editorial, EditorialServiceImpl>{

}
