package com.khabalita.springboot.finalseminario.dto.request;

import java.util.List;

public class BookRequest {
    private String IDBN;
    private String title;
    private String subTitle;
    private Long Edition;
    private Long authorId;
    private Long editorialId;
    private List<Long> categoryIds;
}
