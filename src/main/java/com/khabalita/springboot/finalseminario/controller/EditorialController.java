package com.khabalita.springboot.finalseminario.controller;

import com.khabalita.springboot.finalseminario.dto.EditorialDto;
import com.khabalita.springboot.finalseminario.entities.Editorial;
import com.khabalita.springboot.finalseminario.mapper.EditorialMapper;
import com.khabalita.springboot.finalseminario.services.EditorialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/editorials")
public class EditorialController extends BaseControllerImpl<Editorial, EditorialServiceImpl>{
    @Autowired
    private EditorialServiceImpl editorialService;
    @Autowired
    private EditorialMapper editorialMapper;

    @PostMapping("/createEditorial")
    public ResponseEntity<?> createEditorial(@RequestBody EditorialDto editorialDto){
        try{
            Editorial editorial = editorialMapper.editorialDtoToEditorial(editorialDto);
            Editorial savedEditorial = editorialService.save(editorial);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedEditorial);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error to create a editorial\"}");
        }
    }

    @GetMapping("/getOne/{id}")
    @ResponseBody
    public ResponseEntity<?> getEditorial(@PathVariable Long id){
        try{
            Editorial editorial = servicio.findById(id);
            if(editorial != null){
                EditorialDto editorialDto = editorialMapper.editorialToEditorialDto(editorial);
                return ResponseEntity.status(HttpStatus.OK).body(editorialDto);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Editorial not found}");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to get one Editorial}");
        }

    }

    @GetMapping("/listEditorials")
    @ResponseBody
    public ResponseEntity<?> getAllEditorials(){
        try{
            List<Editorial> editorials = editorialService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(editorials);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error to get editorials\"}");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEditorial(@PathVariable Long id, @RequestBody EditorialDto editorialDto){
        try{
            Editorial editorialDtoToUpdate = editorialMapper.editorialDtoToEditorial(editorialDto);
            Editorial updatedEditorial = servicio.update(id, editorialDtoToUpdate);
            if(updatedEditorial != null){
                return ResponseEntity.status(HttpStatus.OK).body(updatedEditorial);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Editorial not found}");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to update editorial}");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEditorial(@PathVariable Long id){
        try{
            boolean deleted = servicio.delete(id);
            if(deleted){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Editorial not found}");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error to delete editorial}");
        }
    }
}
