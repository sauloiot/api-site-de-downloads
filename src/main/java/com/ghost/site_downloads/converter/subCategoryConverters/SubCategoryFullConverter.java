package com.ghost.site_downloads.converter.subCategoryConverters;

import com.ghost.site_downloads.converter.itemConverters.ItemConverter;
import com.ghost.site_downloads.dto.subCategoryDTO.SubCategoryFullDTO;
import com.ghost.site_downloads.dto.subCategoryDTO.SubCategoryWItensDTO;
import com.ghost.site_downloads.models.SubCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubCategoryFullConverter {

    public static SubCategoryFullDTO entityToDTO(SubCategory subCategory){
        SubCategoryFullDTO dto = new SubCategoryFullDTO();
        dto.setSub_category_id(subCategory.getSub_category_id());
        dto.setSub_category_name(subCategory.getSub_category_name());
        dto.setSub_category_description(subCategory.getSub_category_description());
        dto.setImages(subCategory.getImages());
        dto.getItemDTOS().addAll(ItemConverter.entityToDTOList(subCategory.getItems()));
        dto.setUser_id(subCategory.getAccUser().getUser_id());
        dto.setCategory_id(subCategory.getCategory().getCategory_id());

        return dto;
    }

    public static List<SubCategoryFullDTO> entityToDTOList(List<SubCategory> subCategories){
        List<SubCategoryFullDTO> list = new ArrayList<>();
        for (SubCategory a : subCategories) list.add(entityToDTO(a));
        return list;
        //return subCategory.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static SubCategory dtoToEntity(SubCategoryFullDTO subCategoryDTO){
        SubCategory entity = new SubCategory();
        entity.setSub_category_id(subCategoryDTO.getSub_category_id());
        entity.setSub_category_name(subCategoryDTO.getSub_category_name());
        entity.setSub_category_description(subCategoryDTO.getSub_category_description());
        entity.setImages(subCategoryDTO.getImages());
        entity.getItems().addAll(ItemConverter.dtoToEntityList(subCategoryDTO.getItemDTOS()));
        entity.getAccUser().setUser_id(subCategoryDTO.getUser_id());
        entity.getCategory().setCategory_id(subCategoryDTO.getCategory_id());
        return entity;
    }

    public static List<SubCategory> dtoToEntityList(List<SubCategoryFullDTO> subCategoryDTO){

        return subCategoryDTO.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
