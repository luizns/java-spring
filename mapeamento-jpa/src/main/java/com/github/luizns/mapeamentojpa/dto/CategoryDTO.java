package com.github.luizns.mapeamentojpa.dto;

import com.github.luizns.mapeamentojpa.entities.Category;

public record CategoryDTO(Long id, String name) {

    public CategoryDTO(Category entity) {
        this(entity.getId(),entity.getName());
    }
}
