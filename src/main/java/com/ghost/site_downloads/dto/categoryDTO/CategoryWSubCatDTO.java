package com.ghost.site_downloads.dto.categoryDTO;

import com.ghost.site_downloads.dto.subCategoryDTO.SubCategoryDTO;
import com.ghost.site_downloads.models.Category;
import com.ghost.site_downloads.models.Images;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CategoryWSubCatDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer category_id;
    private String category_name;
    private String category_description;
    private List<Images> images;
    private List<SubCategoryDTO> subCategoryDTOS;

    public CategoryWSubCatDTO() {
        subCategoryDTOS = new ArrayList<>();
    }

    public CategoryWSubCatDTO(Category obj) {
        category_id = obj.getCategory_id();
        category_name = obj.getCategory_name();
        category_description = obj.getCategory_description();
        images = obj.getImages();
        subCategoryDTOS = obj.getSubCategories().stream().map(sub -> new SubCategoryDTO(sub)).collect(Collectors.toList());
    }

//    public Category dtoToCategory(){
//        return new Category(category_id, category_name, category_description, images, subCategoryDTOS);
//    }
    
    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public List<SubCategoryDTO> getSubCategoryDTOS() {
        return subCategoryDTOS;
    }

    public void setSubCategoryDTOS(List<SubCategoryDTO> subCategoryDTOS) {
        this.subCategoryDTOS = subCategoryDTOS;
    }
}
