package com.ghost.site_downloads.converter.categoryConverters;

import com.ghost.site_downloads.converter.subCategoryConverters.SubCategoryConverter;
import com.ghost.site_downloads.dto.categoryDTO.CategoryWSubCatDTO;
import com.ghost.site_downloads.models.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryConverter {

    public static CategoryWSubCatDTO entityToDTO(Category category){
        CategoryWSubCatDTO dto = new CategoryWSubCatDTO();
        dto.setCategory_id(category.getCategory_id());
        dto.setCategory_name(category.getCategory_name());
        dto.setCategory_description(category.getCategory_description());
        dto.setImages(category.getImages());
        dto.getSubCategoryDTOS().addAll(SubCategoryConverter.entityToDTOList(category.getSubCategories()));

        return dto;
    }

    public List<CategoryWSubCatDTO> entityToDTOList(List<Category> category){

        return category.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public Category dtoToEntity(CategoryWSubCatDTO categoryWSubCatDTO){
        Category entity = new Category();
        entity.setCategory_id(categoryWSubCatDTO.getCategory_id());
        entity.setCategory_name(categoryWSubCatDTO.getCategory_name());
        entity.setCategory_description(categoryWSubCatDTO.getCategory_description());
        entity.setImages(categoryWSubCatDTO.getImages());
        entity.getSubCategories().addAll(SubCategoryConverter.dtoToEntityList(categoryWSubCatDTO.getSubCategoryDTOS()));

        return entity;
    }

    public List<Category> dtoToEntityList(List<CategoryWSubCatDTO> categoryWSubCatDTO){
        return categoryWSubCatDTO.stream().map(x ->  dtoToEntity(x)).collect(Collectors.toList());
    }

}
