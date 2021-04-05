package com.ghost.site_downloads.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer item_id;
    private String item_name;
    private String item_description;
    private Date created_at;
    private Date release_date;

    //    Relationships
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AccUser accUser = new AccUser();
    @ManyToOne
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory = new SubCategory();


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Images> images = new ArrayList<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Link> links = new ArrayList<>();


    public Item() {
    }

    public Item(Integer item_id, String item_name, String item_desciption, Date created_at, Date release_date, AccUser accUser, SubCategory subCategory) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_description = item_desciption;
        this.created_at = created_at;
        this.release_date = release_date;
        this.accUser = accUser;
        this.subCategory = subCategory;
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

    public AccUser getAccUser() {
        return accUser;
    }

    public void setAccUser(AccUser accUser) {
        this.accUser = accUser;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return item_id == item.item_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id);
    }
}
