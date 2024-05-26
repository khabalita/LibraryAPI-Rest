package com.khabalita.springboot.finalseminario.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    @NotBlank
    private String name;
}
