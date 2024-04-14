package com.khabalita.springboot.finalseminario.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class AuthorsResponse {
    private List<AuthorResponse> authors;
}
