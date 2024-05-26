package com.khabalita.springboot.finalseminario.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookDto {
    private Long id;
    private String ISBN;
    private String title;
    private String subTitle;
    private Long edition;
    private AuthorDto authorDto;
    private EditorialDto editorialDto;
    private List<CategoryDto> categoryDto;
}
