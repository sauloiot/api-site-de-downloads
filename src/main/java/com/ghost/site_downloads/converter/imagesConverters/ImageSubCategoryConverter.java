package com.ghost.site_downloads.converter.imagesConverters;

import com.ghost.site_downloads.dto.ImagesDTO.ImagesCategoryDTO;
import com.ghost.site_downloads.dto.ImagesDTO.ImagesSubCategoryDTO;
import com.ghost.site_downloads.models.Images;

import java.util.List;
import java.util.stream.Collectors;

public class ImageSubCategoryConverter {
    public static ImagesSubCategoryDTO entityToDTO(Images images){
        ImagesSubCategoryDTO dto = new ImagesSubCategoryDTO();

        dto.setImage_id(images.getImage_id());
        dto.setImage_path(images.getImage_path());
        dto.setSubcategory_id(images.getSubCategory().getSub_category_id());

        return dto;
    }
    public static List<ImagesSubCategoryDTO> entityToDTOList(List<Images> images){
        return images.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }

    public static Images dtoToEntity(ImagesSubCategoryDTO dto){
        Images images = new Images();

        images.setImage_id(dto.getImage_id());
        images.setImage_path(dto.getImage_path());
        images.getSubCategory().setSub_category_id(dto.getSubcategory_id());

        return images;
    }

    public static List<Images> dtoToEntityList(List<ImagesSubCategoryDTO> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
