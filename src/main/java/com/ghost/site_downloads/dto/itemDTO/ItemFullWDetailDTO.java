package com.ghost.site_downloads.dto.itemDTO;

import com.ghost.site_downloads.converter.accUserConverters.AccUserBasicConverter;
import com.ghost.site_downloads.converter.subCategoryConverters.SubCategoryMinimalConverter;
import com.ghost.site_downloads.dto.AccUserDTO.AccUserBasicDTO;
import com.ghost.site_downloads.dto.subCategoryDTO.SubCategoryMinimalDTO;
import com.ghost.site_downloads.models.Images;
import com.ghost.site_downloads.models.Item;
import com.ghost.site_downloads.models.Link;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ItemFullWDetailDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer item_id;
    private String item_name;
    private String item_description;
    private List<Images> images;
    private List<Link> links;
    private Date created_at;
    private Date release_date;
    private AccUserBasicDTO accUser;
    private SubCategoryMinimalDTO SubCategory;

    public ItemFullWDetailDTO() {
    }

    public ItemFullWDetailDTO(Item obj) {
        item_id = obj.getItem_id();
        item_name = obj.getItem_name();
        item_description = obj.getItem_description();
        images = obj.getImages();
        links = obj.getLinks();
        created_at = obj.getCreated_at();
        release_date = obj.getRelease_date();
        accUser = AccUserBasicConverter.entityToDTO(obj.getAccUser());
        SubCategory = SubCategoryMinimalConverter.entityToDTO(obj.getSubCategory());
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public AccUserBasicDTO getAccUser() {
        return accUser;
    }

    public void setAccUser(AccUserBasicDTO accUser) {
        this.accUser = accUser;
    }

    public SubCategoryMinimalDTO getSubCategory() {
        return SubCategory;
    }

    public void setSubCategory(SubCategoryMinimalDTO subCategory) {
        SubCategory = subCategory;
    }
}
