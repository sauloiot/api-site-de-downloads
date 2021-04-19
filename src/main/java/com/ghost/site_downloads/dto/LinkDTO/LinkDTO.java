package com.ghost.site_downloads.dto.LinkDTO;

import com.ghost.site_downloads.models.Link;

import java.io.Serializable;

public class LinkDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer link_id;
    private String link_url;
    private String link_description;
    private Integer item_id;

    public LinkDTO() {
    }

    public LinkDTO(Link link){
        link_id = link.getLink_id();
        link_url = link.getLink_url();
        link_description = link.getLink_description();
        item_id = link.getItem().getItem_id();
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

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }
}
