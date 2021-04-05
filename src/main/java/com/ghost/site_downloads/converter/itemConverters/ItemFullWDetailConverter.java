package com.ghost.site_downloads.converter.itemConverters;

import com.ghost.site_downloads.converter.accUserConverters.AccUserBasicConverter;
import com.ghost.site_downloads.converter.subCategoryConverters.SubCategoryMinimalConverter;
import com.ghost.site_downloads.dto.itemDTO.ItemFullDTO;
import com.ghost.site_downloads.dto.itemDTO.ItemFullWDetailDTO;
import com.ghost.site_downloads.models.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemFullWDetailConverter {
    public static ItemFullWDetailDTO entityToDTO(Item item){
        ItemFullWDetailDTO dto = new ItemFullWDetailDTO();
        dto.setItem_id(item.getItem_id());
        dto.setItem_name(item.getItem_description());
        dto.setItem_description(item.getItem_description());
        dto.setImages(item.getImages());
        dto.setLinks(item.getLinks());
        dto.setCreated_at(item.getCreated_at());
        dto.setRelease_date(item.getRelease_date());
        dto.setAccUser(AccUserBasicConverter.entityToDTO(item.getAccUser()));
        dto.setSubCategory(SubCategoryMinimalConverter.entityToDTO(item.getSubCategory()));

        return dto;
    }

    public static List<ItemFullWDetailDTO> entityToDTOList(List<Item> items){
        return items.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static Item dtoToEntity(ItemFullWDetailDTO dto){
        Item item = new Item();
        item.setItem_id(dto.getItem_id());
        item.setItem_name(dto.getItem_description());
        item.setItem_description(dto.getItem_description());
        item.setImages(dto.getImages());
        item.setLinks(dto.getLinks());
        item.setCreated_at(dto.getCreated_at());
        item.setRelease_date(dto.getRelease_date());
        item.setAccUser(AccUserBasicConverter.dtoToEntity(dto.getAccUser()));
        item.setSubCategory(SubCategoryMinimalConverter.dtoToEntity(dto.getSubCategory()));

        return item;
    }

    public static List<Item> dtoToEntityList(List<ItemFullWDetailDTO> items){
        return items.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
