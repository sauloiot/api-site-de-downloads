package com.ghost.site_downloads.dto.ImagesDTO;

import com.ghost.site_downloads.models.Images;

import java.io.Serializable;

public class ImagesCategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer image_id;
    private String image_path;
    private Integer category_id;

    public ImagesCategoryDTO() {
    }

    public ImagesCategoryDTO(Images obj) {
        image_id = obj.getImage_id();
        image_path = obj.getImage_path();
        category_id = obj.getCategory().getCategory_id();
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

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
