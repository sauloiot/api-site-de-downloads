package com.ghost.site_downloads.converter.categoryConverters;

import com.ghost.site_downloads.dto.categoryDTO.CategoryBasicDTO;
import com.ghost.site_downloads.dto.categoryDTO.CategoryBasicWAccUserDTO;
import com.ghost.site_downloads.models.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryBasicWAccUserConverter {

    public static CategoryBasicWAccUserDTO entityToDTO(Category category){
        CategoryBasicWAccUserDTO dto = new CategoryBasicWAccUserDTO();
        dto.setCategory_id(category.getCategory_id());
        dto.setCategory_name(category.getCategory_name());
        dto.setCategory_description(category.getCategory_description());
        dto.setUser_id(category.getAccUser().getUser_id());

        return dto;
    }

    public static List<CategoryBasicWAccUserDTO> entityToDTOList(List<Category> category){

        return category.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static Category dtoToEntity(CategoryBasicWAccUserDTO categoryBasicWAccUserDTO){
        Category entity = new Category();
        entity.setCategory_id(categoryBasicWAccUserDTO.getCategory_id());
        entity.setCategory_name(categoryBasicWAccUserDTO.getCategory_name());
        entity.setCategory_description(categoryBasicWAccUserDTO.getCategory_description());
        entity.getAccUser().setUser_id(categoryBasicWAccUserDTO.getUser_id());

        return entity;
    }

    public static List<Category> dtoToEntityList(List<CategoryBasicWAccUserDTO> categoryWSubCatDTO){
        return categoryWSubCatDTO.stream().map(x ->  dtoToEntity(x)).collect(Collectors.toList());
    }

}
