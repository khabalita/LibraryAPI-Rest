package com.khabalita.springboot.finalseminario.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse {
    private List<CategoryResponse> categories;
}
