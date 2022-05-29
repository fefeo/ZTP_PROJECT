package com.example.ZTP_PROJ6.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.UUID;

@Entity(name="Recipes")

public class Recipe {
    @Id
    @Column(
            name="id",
            updatable = false
    )
    private String id;
    @Column(
            name="name",
            nullable = false
    )
    private String name;
    @Column(
            name="description",
            length = 1200
    )
    private String description;
    @Column(
            name="ingredients",
            nullable = false,
            length = 1200
    )
    private String ingredients;
    @Column(
            name="level",
            nullable = false

    )
    private Integer level;

    @ManyToOne(cascade= CascadeType.PERSIST)//{CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="photo_id", referencedColumnName = "id")
    private Photo photo;



    public Recipe() {

    }


    //private String photo_Id;


    public Recipe(String id, String name, String description, String ingredients, Integer level, User user, Photo photo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.level = level;
        this.user = user;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public Integer getLevel() {
        return level;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public static String idCreator() {
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", level=" + level +
                ", user=" + user +
                ", photo=" + photo +
                '}';
    }
}
