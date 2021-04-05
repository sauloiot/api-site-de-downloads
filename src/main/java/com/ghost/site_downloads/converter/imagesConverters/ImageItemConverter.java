package com.ghost.site_downloads.converter.imagesConverters;

import com.ghost.site_downloads.dto.ImagesDTO.ImagesItemDTO;
import com.ghost.site_downloads.dto.ImagesDTO.ImagesSubCategoryDTO;
import com.ghost.site_downloads.models.Images;

import java.util.List;
import java.util.stream.Collectors;

public class ImageItemConverter {
    public static ImagesItemDTO entityToDTO(Images images){
        ImagesItemDTO dto = new ImagesItemDTO();

        dto.setImage_id(images.getImage_id());
        dto.setImage_path(images.getImage_path());
        dto.setItem_id(images.getItem().getItem_id());

        return dto;
    }
    public static List<ImagesItemDTO> entityToDTOList(List<Images> images){
        return images.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static Images dtoToEntity(ImagesItemDTO dto){
        Images images = new Images();

        images.setImage_id(dto.getImage_id());
        images.setImage_path(dto.getImage_path());
        images.getItem().setItem_id(dto.getItem_id());

        return images;
    }

    public static List<Images> dtoToEntityList(List<ImagesItemDTO> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
