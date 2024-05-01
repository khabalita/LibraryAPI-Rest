package com.khabalita.springboot.finalseminario.dto;

import lombok.Data;

@Data
public class BookDto {
    private String ISBN;
    private String title;
    private String subTitle;
    private Long Edition;
    private AuthorDto authorDto;
    private EditorialDto editorialDto;
    private CategoryDto categoryDto;
}
