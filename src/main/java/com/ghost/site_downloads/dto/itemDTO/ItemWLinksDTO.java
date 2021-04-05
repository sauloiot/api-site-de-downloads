package com.ghost.site_downloads.dto.itemDTO;

import com.ghost.site_downloads.models.Images;
import com.ghost.site_downloads.models.Item;
import com.ghost.site_downloads.models.Link;

import java.io.Serializable;
import java.util.List;

public class ItemWLinksDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer item_id;
    private String item_name;
    private String item_description;
    private List<Images> images;
    private List<Link> links;

    public ItemWLinksDTO() {
    }

    public ItemWLinksDTO(Item obj) {
        item_id = obj.getItem_id();
        item_name = obj.getItem_name();
        item_description = obj.getItem_description();
        images = obj.getImages();
        links = obj.getLinks();
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}
