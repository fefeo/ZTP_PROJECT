package com.example.ZTP_PROJ6.requests;

public class RecipeRequest {
    //String name, String description, String ingredients, Integer level
    private String name;
    private String description;
    private String ingredients;
    private Integer level;

    public RecipeRequest(String name, String description, String ingredients, Integer level) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.level = level;
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
