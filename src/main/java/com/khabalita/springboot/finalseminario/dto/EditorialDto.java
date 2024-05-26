package com.khabalita.springboot.finalseminario.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EditorialDto {
    private Long id;
    @NotBlank
    private String name;
}
