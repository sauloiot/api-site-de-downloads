package com.ghost.site_downloads.dto.ImagesDTO;

import com.ghost.site_downloads.models.Images;

import java.io.Serializable;

public class ImagesSubCategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer image_id;
    private String image_path;
    private Integer subcategory_id;

    public ImagesSubCategoryDTO() {
    }

    public ImagesSubCategoryDTO(Images obj) {
        image_id = obj.getImage_id();
        image_path = obj.getImage_path();
        subcategory_id = obj.getSubCategory().getSub_category_id();
    }

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public Integer getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(Integer subcategory_id) {
        this.subcategory_id = subcategory_id;
    }
}
