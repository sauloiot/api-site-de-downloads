package com.ghost.site_downloads.converter.subCategoryConverters;

import com.ghost.site_downloads.dto.subCategoryDTO.SubCategoryDTO;
import com.ghost.site_downloads.dto.subCategoryDTO.SubCategoryMinimalDTO;
import com.ghost.site_downloads.models.SubCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubCategoryMinimalConverter {

    public static SubCategoryMinimalDTO entityToDTO(SubCategory subCategory){
        SubCategoryMinimalDTO dto = new SubCategoryMinimalDTO();
        dto.setSub_category_id(subCategory.getSub_category_id());
        dto.setSub_category_name(subCategory.getSub_category_name());
        dto.setSub_category_description(subCategory.getSub_category_description());

        return dto;
    }

    public static List<SubCategoryMinimalDTO> entityToDTOList(List<SubCategory> subCategories){
        List<SubCategoryMinimalDTO> list = new ArrayList<>();
        for (SubCategory a : subCategories) list.add(entityToDTO(a));
        return list;
        //return subCategory.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static SubCategory dtoToEntity(SubCategoryMinimalDTO subCategoryDTO){
        SubCategory entity = new SubCategory();
        entity.setSub_category_id(subCategoryDTO.getSub_category_id());
        entity.setSub_category_name(subCategoryDTO.getSub_category_name());
        entity.setSub_category_description(subCategoryDTO.getSub_category_description());

        return entity;
    }

    public static List<SubCategory> dtoToEntityList(List<SubCategoryMinimalDTO> subCategoryDTO){

        return subCategoryDTO.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
