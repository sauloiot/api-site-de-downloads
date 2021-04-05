package com.ghost.site_downloads.converter.itemConverters;

import com.ghost.site_downloads.dto.itemDTO.ItemFullDTO;
import com.ghost.site_downloads.models.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemFullConverter {
    public static ItemFullDTO entityToDTO(Item item){
        ItemFullDTO dto = new ItemFullDTO();
        dto.setItem_id(item.getItem_id());
        dto.setItem_name(item.getItem_description());
        dto.setItem_description(item.getItem_description());
        dto.setImages(item.getImages());
        dto.setLinks(item.getLinks());
        dto.setCreated_at(item.getCreated_at());
        dto.setRelease_date(item.getRelease_date());
        dto.setUser_id(item.getAccUser().getUser_id());
        dto.setSubcategory_id(item.getSubCategory().getSub_category_id());

        return dto;
    }

    public static List<ItemFullDTO> entityToDTOList(List<Item> items){
        return items.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static Item dtoToEntity(ItemFullDTO dto){
        Item item = new Item();
        item.setItem_id(dto.getItem_id());
        item.setItem_name(dto.getItem_name());
        item.setItem_description(dto.getItem_description());
        item.setImages(dto.getImages());
        item.setLinks(dto.getLinks());
        item.setCreated_at(dto.getCreated_at());
        item.setRelease_date(dto.getRelease_date());
        item.getAccUser().setUser_id(dto.getUser_id());
        item.getSubCategory().setSub_category_id(dto.getSubcategory_id());

        return item;
    }

    public static List<Item> dtoToEntityList(List<ItemFullDTO> items){
        return items.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
