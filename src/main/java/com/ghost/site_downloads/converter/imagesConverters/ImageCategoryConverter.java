package com.ghost.site_downloads.converter.imagesConverters;

import com.ghost.site_downloads.dto.ImagesDTO.ImagesCategoryDTO;
import com.ghost.site_downloads.models.Images;

import java.util.List;
import java.util.stream.Collectors;

public class ImageCategoryConverter {
    public static ImagesCategoryDTO entityToDTO(Images images){
        ImagesCategoryDTO dto = new ImagesCategoryDTO();

        dto.setImage_id(images.getImage_id());
        dto.setImage_path(images.getImage_path());
        dto.setCategory_id(images.getCategory().getCategory_id());

        return dto;
    }
    public static List<ImagesCategoryDTO> entityToDTOList(List<Images> images){
        return images.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static Images dtoToEntity(ImagesCategoryDTO dto){
        Images images = new Images();

        images.setImage_id(dto.getImage_id());
        images.setImage_path(dto.getImage_path());
        images.getCategory().setCategory_id(dto.getCategory_id());

        return images;
    }

    public static List<Images> dtoToEntityList(List<ImagesCategoryDTO> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
