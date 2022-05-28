package com.example.ZTP_PROJ6.controllers;


import com.example.ZTP_PROJ6.beans.Recipe;
import com.example.ZTP_PROJ6.exceptions.NotFoundException;
import com.example.ZTP_PROJ6.repositorys.RecipeRepository;
import com.example.ZTP_PROJ6.repositorys.UserRepository;
import com.example.ZTP_PROJ6.requests.RecipeRequest;
import com.example.ZTP_PROJ6.services.DashboardService;
import com.example.ZTP_PROJ6.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecipeRepository recipeRepository;


    @GetMapping
    public List<Recipe> getAllRecipes() {return dashboardService.getAllRecipes(); }

    @GetMapping("/all")
    public List<Recipe> getAllUserRecipes(){
        return dashboardService.getAllUserRecipes();
    }


    @PostMapping
    public List<Recipe> addRecipe(@RequestBody RecipeRequest request) {
        return dashboardService.addRecipe(request.getName(), request.getDescription(), request.getIngredients(), request.getLevel());
    }

    @RequestMapping (value = "/{recipeId}", method = RequestMethod.DELETE)
    public List<Recipe> deleteRecipe(@PathVariable String recipeId) throws NotFoundException {
        return dashboardService.deleteRecipeById(recipeId);
    }

    @RequestMapping (value = "user/{recipeId}", method = RequestMethod.DELETE)
    public List<Recipe> deleteUserRecipe(@PathVariable String recipeId) throws NotFoundException {
        return dashboardService.deleteUserRecipeById(recipeId);
    }
}
