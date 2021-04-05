package com.ghost.site_downloads.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Link implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer link_id;
    private String link_url;
    private String link_description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item = new Item();

    public Link() {
    }

    public Link(Integer link_id, String link_url, String link_description, Item item) {
        this.link_id = link_id;
        this.link_url = link_url;
        this.link_description = link_description;
        this.item = item;
    }

    public Integer getLink_id() {
        return link_id;
    }

    public void setLink_id(Integer link_id) {
        this.link_id = link_id;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String getLink_description() {
        return link_description;
    }

    public void setLink_description(String link_description) {
        this.link_description = link_description;
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
        Link link = (Link) o;
        return link_id == link.link_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(link_id);
    }
}
