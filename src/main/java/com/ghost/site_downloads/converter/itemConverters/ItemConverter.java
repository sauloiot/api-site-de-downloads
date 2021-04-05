package com.ghost.site_downloads.converter.itemConverters;

import com.ghost.site_downloads.dto.itemDTO.ItemDTO;
import com.ghost.site_downloads.models.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemConverter {
    public static ItemDTO entityToDTO(Item item){
        ItemDTO dto = new ItemDTO();
        dto.setItem_id(item.getItem_id());
        dto.setItem_name(item.getItem_description());
        dto.setItem_description(item.getItem_description());
        dto.setImages(item.getImages());

        return dto;
    }

    public static List<ItemDTO> entityToDTOList(List<Item> items){
        return items.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static Item dtoToEntity(ItemDTO dto){
        Item item = new Item();
        item.setItem_id(dto.getItem_id());
        item.setItem_name(dto.getItem_description());
        item.setItem_description(dto.getItem_description());
        item.setImages(dto.getImages());

        return item;
    }

    public static List<Item> dtoToEntityList(List<ItemDTO> items){
        return items.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
