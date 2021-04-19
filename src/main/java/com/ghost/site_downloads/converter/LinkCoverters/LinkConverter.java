package com.ghost.site_downloads.converter.LinkCoverters;

import com.ghost.site_downloads.dto.LinkDTO.LinkDTO;
import com.ghost.site_downloads.dto.itemDTO.ItemDTO;
import com.ghost.site_downloads.models.Link;

import java.util.List;
import java.util.stream.Collectors;

public class LinkConverter {
    public static LinkDTO entityToDTO(Link link){
        LinkDTO dto = new LinkDTO();
        dto.setLink_id(link.getLink_id());
        dto.setLink_url(link.getLink_url());
        dto.setLink_description(link.getLink_description());
        dto.setItem_id(link.getItem().getItem_id());

        return dto;
    }

    public static List<LinkDTO> entityToDTOList(List<Link> link){
        return link.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static Link dtoToEntity(LinkDTO dto){
        Link link = new Link();
        link.setLink_id(dto.getLink_id());
        link.setLink_url(dto.getLink_url());
        link.setLink_description(dto.getLink_description());
        link.getItem().setItem_id(dto.getItem_id());

        return link;
    }

    public static List<Link> dtoToEntityList(List<LinkDTO> link){
        return link.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
