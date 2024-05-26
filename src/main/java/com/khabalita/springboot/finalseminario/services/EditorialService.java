package com.khabalita.springboot.finalseminario.services;

import com.khabalita.springboot.finalseminario.dto.EditorialDto;
import com.khabalita.springboot.finalseminario.entities.Editorial;
import com.khabalita.springboot.finalseminario.mapper.EditorialMapper;
import com.khabalita.springboot.finalseminario.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EditorialService{
    @Autowired
    private EditorialRepository editorialRepository;

    @Autowired
    private EditorialMapper editorialMapper;

    public Editorial newEditorial(EditorialDto editorialDto) throws Exception{
        try{
            Editorial editorial = editorialMapper.editorialDtoToEditorial(editorialDto);
            Editorial savedEditorial = editorialRepository.save(editorial);
            return savedEditorial;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<EditorialDto> listAllEditorials() throws Exception{
        try{
            List<Editorial> editorialList = editorialRepository.findAll();
            List<EditorialDto> editorialDtoList = new ArrayList<>();
            for(Editorial editorial: editorialList) {
                editorialDtoList.add(editorialMapper.editorialToEditorialDto(editorial));
            }
            return editorialDtoList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public EditorialDto updateEditorial(Long id, EditorialDto editorialDto) throws Exception {
        try {
            Editorial existingEditorial = editorialRepository.findById(id)
                    .orElseThrow(() -> new Exception("Id de editorial no encontrado" + id));
            existingEditorial.setName(editorialDto.getName());
            Editorial updatedEditorial = editorialRepository.save(existingEditorial);
            return editorialMapper.editorialToEditorialDto(updatedEditorial);
        } catch (Exception e) {
            throw new Exception (e.getMessage());
        }
    }

    public boolean deleteEditorial(Long id) throws Exception{
        try{
            if(editorialRepository.existsById(id)){
                editorialRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("ID not found" + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public EditorialDto findEditorialById(Long id) throws Exception{
        try{
            Editorial editorial = editorialRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de editoria no encontrado" + id));
            return editorialMapper.editorialToEditorialDto(editorial);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
