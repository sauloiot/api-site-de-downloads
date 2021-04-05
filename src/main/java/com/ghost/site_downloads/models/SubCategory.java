package com.ghost.site_downloads.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class SubCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sub_category_id;
    private String sub_category_name;
    private String sub_category_description;

    //    Relationships
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AccUser accUser = new AccUser();
//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category = new Category();

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    private List<Images> images = new ArrayList<>();


    public SubCategory() {
    }

    public SubCategory(Integer sub_category_id, String sub_category_name, String sub_category_description, AccUser accUser, Category category) {
        this.sub_category_id = sub_category_id;
        this.sub_category_name = sub_category_name;
        this.sub_category_description = sub_category_description;
        this.accUser = accUser;
        this.category = category;
    }

//    public SubCategory(Integer sub_category_id, String sub_category_name, String sub_category_description, List<Images> images) {
//        this.sub_category_id = sub_category_id;
//        this.sub_category_name = sub_category_name;
//        this.sub_category_description = sub_category_description;
//        this.images = images;
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

    public AccUser getAccUser() {
        return accUser;
    }

    public void setAccUser(AccUser accUser) {
        this.accUser = accUser;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
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
        SubCategory that = (SubCategory) o;
        return sub_category_id == that.sub_category_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sub_category_id);
    }


}
