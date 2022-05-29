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
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecipeRepository recipeRepository;

    public List<User> getAllUseres() {
        return userRepository.findAll();
    }

    public List<User> addUser(String username, String password) {
        if(userRepository.existsByLogin(username) == false) {
            userRepository.save(new User(User.idCreator(), username, password, Role.USER));
            return userRepository.findAll();
        }
        throw new ForbiddenException("User with this login alredy exists!");
    }
    public List<User> deleteUserById(String id) throws NotFoundException {
            if(userRepository.existsById(id)) {
                setNull(id);
                userRepository.deleteById(id);
                return userRepository.findAll();
            }
                throw new NotFoundException("User not found!");
    }

    public User getUserByLogin(String login) {
        if (userRepository.findAllByLogin(login) == null) {
            return null;
        } else {
            return userRepository.findAllByLogin(login);
        }
    }
    public List<Recipe> setNull (String id) {

        List<Recipe> UsersRecipes = recipeRepository.findAllByUser_Id(id);
        System.out.println("toto");
        System.out.println(UsersRecipes);
        for (Recipe recipe: UsersRecipes) {
            recipe.setUser(null);
            recipeRepository.save(recipe);
        }
        return recipeRepository.findAll();
    }
}
