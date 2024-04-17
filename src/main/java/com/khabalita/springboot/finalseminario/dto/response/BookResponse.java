package com.khabalita.springboot.finalseminario.dto.response;

import lombok.Data;

@Data
public class BookResponse {
    private String ISBN;
    private String title;
    private String subTitle;
    private Long Edition;
    private AuthorResponse authorResponse;
    private EditorialResponse editorialResponse;
    private CategoryResponse categoryResponse;
}
