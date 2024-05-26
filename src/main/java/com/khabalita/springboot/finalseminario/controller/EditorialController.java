package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.dto.EditorialDto;
import com.khabalita.springboot.finalseminario.services.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/editorials")
public class EditorialController{
    @Autowired
    private EditorialService editorialService;

    @PostMapping("/createEditorial")
    public ResponseEntity<?> createEditorial(@RequestBody EditorialDto editorialDto) throws Exception{
        editorialService.newEditorial(editorialDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getOne/{id}")
    @ResponseBody
    public ResponseEntity<?> getEditorial(@PathVariable Long id) throws Exception{
        EditorialDto editorialDto = editorialService.findEditorialById(id);
        if(editorialDto != null){
            return ResponseEntity.status(HttpStatus.OK).body(editorialDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
    }

    @GetMapping("/listEditorials")
    @ResponseBody
    public ResponseEntity<?> getAllEditorials() throws Exception{
        List<EditorialDto> editorialDtoList = editorialService.listAllEditorials();
        return ResponseEntity.status(HttpStatus.OK).body(editorialDtoList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEditorial(@PathVariable Long id, @RequestBody EditorialDto editorialDto) throws Exception{
        EditorialDto updatedEditorial = editorialService.updateEditorial(id, editorialDto);
        if(updatedEditorial != null){
            return ResponseEntity.status(HttpStatus.OK).body(updatedEditorial);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Editorial not found}");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEditorial(@PathVariable Long id) throws Exception{
        boolean deleted = editorialService.deleteEditorial(id);
        if(deleted){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Editorial not found");
        }
    }
}
