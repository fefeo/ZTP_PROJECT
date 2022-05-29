package com.example.ZTP_PROJ6.services;

import com.example.ZTP_PROJ6.beans.Recipe;
import com.example.ZTP_PROJ6.beans.Role;
import com.example.ZTP_PROJ6.beans.User;
import com.example.ZTP_PROJ6.exceptions.ForbiddenException;
import com.example.ZTP_PROJ6.exceptions.NotFoundException;
import com.example.ZTP_PROJ6.repositorys.RecipeRepository;
import com.example.ZTP_PROJ6.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DashboardService {
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    UserRepository userRepository;


    public List<Recipe> getAllRecipes() {
    return recipeRepository.findAll();
}


    public List<Recipe> getAllUserRecipes() {
         String auth = SecurityContextHolder.getContext().getAuthentication().getName();
         System.out.println(auth);
         User user = userRepository.findAllByLogin(auth);
         System.out.println(user);
        return recipeRepository.findAllByUser_Id(user.getId());
    }

    public List<Recipe> addRecipe(String name, String description, String ingredients, Integer level) {
        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findAllByLogin(auth);
        recipeRepository.save(new Recipe(Recipe.idCreator(), name, description,ingredients, level, user));
        return recipeRepository.findAll();
    }
    public List<Recipe> deleteRecipeById(String id) throws NotFoundException {
        if(recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
            return recipeRepository.findAll();
        }
        throw new NotFoundException("Recipe not found!");
    }
    public List<Recipe> deleteUserRecipeById(String id) throws NotFoundException {
        if(recipeRepository.existsById(id)) {
            Recipe recipe = recipeRepository.getById(id);
            String auth = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userRepository.findAllByLogin(auth);
          //  System.out.println(recipe.getUser());
            System.out.println(user.getId());
            System.out.println(id);
            if(recipe.getUser().getId().equals(user.getId())) {
                recipeRepository.deleteById(id);
                return recipeRepository.findAll();
            } else throw new ForbiddenException("You do not have access to this resource!");
        }
        throw new NotFoundException("Recipe not found!");
    }
}
