package com.ghost.site_downloads.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ghost.site_downloads.models.enums.UserType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


@Entity
public class AccUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String user_name;
    @Column(unique = true)
    private String email;
    private String user_password;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "USER_TYPE")
    private Set<Integer> user_type = new HashSet<>();

    //Collections
    @JsonIgnore
    @OneToMany(mappedBy = "accUser", cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "accUser", cascade = CascadeType.ALL)
    private List<SubCategory> subCategories = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "accUser", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    public AccUser() {
        setUserType(UserType.CLIENT);
    }

    public AccUser(Integer user_id, String user_name, String email, String user_password) {
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.email = email;
        this.user_password = user_password;
        setUserType(UserType.CLIENT);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Set<UserType> getUserType(){
        return user_type.stream().map(x -> UserType.toEnum(x)).collect(Collectors.toSet());
    }

    public void setUserType(UserType userType){
        user_type.add(userType.getCod());
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccUser accUser = (AccUser) o;
        return user_id == accUser.user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }

}
