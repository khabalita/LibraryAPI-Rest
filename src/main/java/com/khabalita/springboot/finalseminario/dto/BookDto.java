package com.khabalita.springboot.finalseminario.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class BookDto {
    private Long id;
    @NotBlank
    private String ISBN;
    @NotBlank
    private String title;
    @NotBlank
    private String subTitle;
    @NotBlank
    private Long edition;
    private AuthorDto authorDto;
    private EditorialDto editorialDto;
    private List<CategoryDto> categoryDto;
}
