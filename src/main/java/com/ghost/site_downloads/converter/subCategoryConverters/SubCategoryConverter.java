package com.ghost.site_downloads.converter.subCategoryConverters;

import com.ghost.site_downloads.dto.subCategoryDTO.SubCategoryDTO;
import com.ghost.site_downloads.models.SubCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubCategoryConverter {

    public static SubCategoryDTO entityToDTO(SubCategory subCategory){
        SubCategoryDTO dto = new SubCategoryDTO();
        dto.setSub_category_id(subCategory.getSub_category_id());
        dto.setSub_category_name(subCategory.getSub_category_name());
        dto.setSub_category_description(subCategory.getSub_category_description());
        dto.setImages(subCategory.getImages());

        return dto;
    }

    public static List<SubCategoryDTO> entityToDTOList(List<SubCategory> subCategories){
        List<SubCategoryDTO> list = new ArrayList<>();
        for (SubCategory a : subCategories) list.add(entityToDTO(a));
        return list;
        //return subCategory.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static SubCategory dtoToEntity(SubCategoryDTO subCategoryDTO){
        SubCategory entity = new SubCategory();
        entity.setSub_category_id(subCategoryDTO.getSub_category_id());
        entity.setSub_category_name(subCategoryDTO.getSub_category_name());
        entity.setSub_category_description(subCategoryDTO.getSub_category_description());
        entity.setImages(subCategoryDTO.getImages());

        return entity;
    }

    public static List<SubCategory> dtoToEntityList(List<SubCategoryDTO> subCategoryDTO){

        return subCategoryDTO.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
