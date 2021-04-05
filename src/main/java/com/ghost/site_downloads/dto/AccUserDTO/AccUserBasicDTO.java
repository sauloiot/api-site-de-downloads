package com.ghost.site_downloads.dto.AccUserDTO;

import com.ghost.site_downloads.models.AccUser;

import java.io.Serializable;

public class AccUserBasicDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer user_id;
    private String user_name;

    public AccUserBasicDTO() {
    }

    public AccUserBasicDTO(AccUser accUser) {
        user_id = accUser.getUser_id();
        user_name = accUser.getUser_name();
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
