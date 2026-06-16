package com.example.app.service.mappers;

import com.example.app.DTO.CategoryDTO;
import com.example.app.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    Category toBook(CategoryDTO categoryDTO);
}
