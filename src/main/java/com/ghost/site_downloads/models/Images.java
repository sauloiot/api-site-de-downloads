package com.ghost.site_downloads.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class Images implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer image_id;
    private String image_path;

    //Relationships
//    @ManyToOne(optional = true, fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id", nullable = true)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category = new Category();
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory = new SubCategory();
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item = new Item();


    public Images() {
    }

    public Images(Integer image_id, String image_path, Category category, SubCategory subCategory, Item item) {
        this.image_id = image_id;
        this.image_path = image_path;
        this.category = category;
        this.subCategory = subCategory;
        this.item = item;
    }

    public Images(Integer image_id, String image_path, Category category) {
        this.image_id = image_id;
        this.image_path = image_path;
        this.category = category;
    }

    public Images(Integer image_id, String image_path, SubCategory subCategory) {
        this.image_id = image_id;
        this.image_path = image_path;
        this.subCategory = subCategory;
    }

    public Images(Integer image_id, String image_path, Item item) {
        this.image_id = image_id;
        this.image_path = image_path;
        this.item = item;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Images images = (Images) o;
        return image_id == images.image_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(image_id);
    }
}
