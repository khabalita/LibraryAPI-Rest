package com.khabalita.springboot.finalseminario.dto.response;

import lombok.Data;

import java.time.LocalDate;
@Data
public class AuthorResponse {
    private String name;
    private String lastName;
    private String nationality;
    private LocalDate birthdate;
    private LocalDate deathdate;
    private String biography;
}
