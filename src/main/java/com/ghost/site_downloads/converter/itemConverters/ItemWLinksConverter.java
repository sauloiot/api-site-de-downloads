package com.ghost.site_downloads.converter.itemConverters;

import com.ghost.site_downloads.dto.itemDTO.ItemWLinksDTO;
import com.ghost.site_downloads.models.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemWLinksConverter {
    public static ItemWLinksDTO entityToDTO(Item item){
        ItemWLinksDTO dto = new ItemWLinksDTO();
        dto.setItem_id(item.getItem_id());
        dto.setItem_name(item.getItem_description());
        dto.setItem_description(item.getItem_description());
        dto.setImages(item.getImages());
        dto.setLinks(item.getLinks());

        return dto;
    }

    public static List<ItemWLinksDTO> entityToDTOList(List<Item> items){
        return items.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static Item dtoToEntity(ItemWLinksDTO dto){
        Item item = new Item();
        item.setItem_id(dto.getItem_id());
        item.setItem_name(dto.getItem_description());
        item.setItem_description(dto.getItem_description());
        item.setImages(dto.getImages());
        item.setLinks(dto.getLinks());

        return item;
    }

    public static List<Item> dtoToEntityList(List<ItemWLinksDTO> items){
        return items.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }

}
