package com.example.ZTP_PROJ6.beans;

import javax.persistence.*;

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
    //private String photo_Id;


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


    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", level=" + level +
                '}';
    }
}
