package com.example.ZTP_PROJ6.requests;

public class RecipeRequest {
    //String name, String description, String ingredients, Integer level
    private String name;
    private String description;
    private String ingredients;
    private Integer level;
    private String photo_url;

    public RecipeRequest(String name, String description, String ingredients, Integer level, String url) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.level = level;
        this.photo_url = photo_url;
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

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
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
}
