package com.ghost.site_downloads.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;
    private String category_name;
    private String category_description;

//    Relationships
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AccUser accUser = new AccUser();

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<SubCategory> subCategories = new ArrayList<>();


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Images> images = new ArrayList<>();


    public Category() {
    }

    public Category(Integer category_id, String category_name, String category_description, AccUser accUser) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_description = category_description;
        this.accUser = accUser;
    }

//    public Category(Integer category_id, String category_name, String category_description, List<Images> images, List<SubCategoryDTO> subCategoryDTOS) {
//        this.category_id = category_id;
//        this.category_name = category_name;
//        this.category_description = category_description;
//        this.images = images;
//        this.subCategories = subCategoryDTOS;
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

    public AccUser getAccUser() {
        return accUser;
    }

    public void setAccUser(AccUser accUser) {
        this.accUser = accUser;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return category_id == category.category_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_id);
    }
}
