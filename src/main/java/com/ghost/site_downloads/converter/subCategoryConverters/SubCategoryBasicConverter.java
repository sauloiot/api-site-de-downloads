package com.ghost.site_downloads.converter.subCategoryConverters;

import com.ghost.site_downloads.converter.accUserConverters.AccUserBasicConverter;
import com.ghost.site_downloads.converter.categoryConverters.CategoryBasicConverter;
import com.ghost.site_downloads.converter.itemConverters.ItemConverter;
import com.ghost.site_downloads.dto.subCategoryDTO.SubCategoryBasicDTO;
import com.ghost.site_downloads.dto.subCategoryDTO.SubCategoryWItensDTO;
import com.ghost.site_downloads.models.SubCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubCategoryBasicConverter {

    public static SubCategoryBasicDTO entityToDTO(SubCategory subCategory){
        SubCategoryBasicDTO dto = new SubCategoryBasicDTO();
        dto.setSub_category_id(subCategory.getSub_category_id());
        dto.setSub_category_name(subCategory.getSub_category_name());
        dto.setSub_category_description(subCategory.getSub_category_description());
        dto.setImages(subCategory.getImages());
        dto.getItemDTOS().addAll(ItemConverter.entityToDTOList(subCategory.getItems()));
        dto.setAccUser(AccUserBasicConverter.entityToDTO(subCategory.getAccUser()));
        dto.setCategory(CategoryBasicConverter.entityToDTO(subCategory.getCategory()));

        return dto;
    }

    public static List<SubCategoryBasicDTO> entityToDTOList(List<SubCategory> subCategories){
        List<SubCategoryBasicDTO> list = new ArrayList<>();
        for (SubCategory a : subCategories) list.add(entityToDTO(a));
        return list;
        //return subCategory.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static SubCategory dtoToEntity(SubCategoryBasicDTO subCategoryDTO){
        SubCategory entity = new SubCategory();
        entity.setSub_category_id(subCategoryDTO.getSub_category_id());
        entity.setSub_category_name(subCategoryDTO.getSub_category_name());
        entity.setSub_category_description(subCategoryDTO.getSub_category_description());
        entity.setImages(subCategoryDTO.getImages());
        entity.getItems().addAll(ItemConverter.dtoToEntityList(subCategoryDTO.getItemDTOS()));
        entity.setAccUser(AccUserBasicConverter.dtoToEntity(subCategoryDTO.getAccUser()));
        entity.setCategory(CategoryBasicConverter.dtoToEntity(subCategoryDTO.getCategory()));

        return entity;
    }

    public static List<SubCategory> dtoToEntityList(List<SubCategoryBasicDTO> subCategoryDTO){

        return subCategoryDTO.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
