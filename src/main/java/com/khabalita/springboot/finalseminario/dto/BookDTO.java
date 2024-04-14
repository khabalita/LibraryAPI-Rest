package com.khabalita.springboot.finalseminario.dto;

import com.khabalita.springboot.finalseminario.dto.request.AuthorRequest;
import lombok.Data;

@Data
public class BookDTO {
    private String ISBN;
    private String title;
    private String subTitle;
    private Long edition;
    private AuthorRequest author;
    private EditorialDTO editorial;
    private CategoryDTO category;
}
