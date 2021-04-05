package com.ghost.site_downloads.converter.categoryConverters;

import com.ghost.site_downloads.dto.categoryDTO.CategoryBasicDTO;
import com.ghost.site_downloads.models.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryBasicConverter {

    public static CategoryBasicDTO entityToDTO(Category category){
        CategoryBasicDTO dto = new CategoryBasicDTO();
        dto.setCategory_id(category.getCategory_id());
        dto.setCategory_name(category.getCategory_name());
        dto.setCategory_description(category.getCategory_description());

        return dto;
    }

    public static List<CategoryBasicDTO> entityToDTOList(List<Category> category){

        return category.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static Category dtoToEntity(CategoryBasicDTO categoryWSubCatDTO){
        Category entity = new Category();
        entity.setCategory_id(categoryWSubCatDTO.getCategory_id());
        entity.setCategory_name(categoryWSubCatDTO.getCategory_name());
        entity.setCategory_description(categoryWSubCatDTO.getCategory_description());

        return entity;
    }

    public static List<Category> dtoToEntityList(List<CategoryBasicDTO> categoryWSubCatDTO){
        return categoryWSubCatDTO.stream().map(x ->  dtoToEntity(x)).collect(Collectors.toList());
    }

}
