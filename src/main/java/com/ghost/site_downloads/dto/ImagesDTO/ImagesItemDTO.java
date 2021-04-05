package com.ghost.site_downloads.dto.ImagesDTO;

import com.ghost.site_downloads.models.Images;

import java.io.Serializable;

public class ImagesItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer image_id;
    private String image_path;
    private Integer item_id;

    public ImagesItemDTO() {
    }

    public ImagesItemDTO(Images obj) {
        image_id = obj.getImage_id();
        image_path = obj.getImage_path();
        item_id = obj.getItem().getItem_id();
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

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }
}
