package com.ghost.site_downloads.dto.subCategoryDTO;

import com.ghost.site_downloads.dto.itemDTO.ItemDTO;
import com.ghost.site_downloads.models.Images;
import com.ghost.site_downloads.models.SubCategory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubCategoryWItensDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer sub_category_id;
    private String sub_category_name;
    private String sub_category_description;
    private List<Images> images;
    private List<ItemDTO> itemDTOS;

    public SubCategoryWItensDTO() {
        itemDTOS = new ArrayList<>();
    }

    public SubCategoryWItensDTO(SubCategory obj) {
        sub_category_id = obj.getSub_category_id();
        sub_category_name = obj.getSub_category_name();
        sub_category_description = obj.getSub_category_description();
        images = obj.getImages();
        itemDTOS = obj.getItems().stream().map(item -> new ItemDTO(item)).collect(Collectors.toList());
    }

//    public SubCategory dtoToSubCategory(){
//        return new SubCategory(sub_category_id, sub_category_name, sub_category_description, images);
//    }

    public Integer getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(Integer sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public String getSub_category_name() {
        return sub_category_name;
    }

    public void setSub_category_name(String sub_category_name) {
        this.sub_category_name = sub_category_name;
    }

    public String getSub_category_description() {
        return sub_category_description;
    }

    public void setSub_category_description(String sub_category_description) {
        this.sub_category_description = sub_category_description;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public List<ItemDTO> getItemDTOS() {
        return itemDTOS;
    }

    public void setItemDTOS(List<ItemDTO> itemDTOS) {
        this.itemDTOS = itemDTOS;
    }
}
