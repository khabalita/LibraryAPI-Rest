package com.khabalita.springboot.finalseminario.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorDto {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String nationality;
    private LocalDate birthdate;
    private LocalDate deathdate;
    private String biography;
}
