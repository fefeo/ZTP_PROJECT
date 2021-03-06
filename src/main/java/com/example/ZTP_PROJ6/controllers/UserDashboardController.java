package com.example.ZTP_PROJ6.controllers;


import com.example.ZTP_PROJ6.beans.Recipe;
import com.example.ZTP_PROJ6.beans.User;
import com.example.ZTP_PROJ6.exceptions.NotFoundException;
import com.example.ZTP_PROJ6.repositorys.RecipeRepository;
import com.example.ZTP_PROJ6.repositorys.UserRepository;
import com.example.ZTP_PROJ6.requests.UserRequest;
import com.example.ZTP_PROJ6.services.DashboardService;
import com.example.ZTP_PROJ6.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user_dashboard")
public class UserDashboardController {

    @Autowired
    DashboardService dashboardService;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecipeRepository recipeRepository;


    @PostMapping("/createNewUser")
    public User addUser(@RequestBody UserRequest request) {
        return userService.addUser(request.getUsername(), request.getPassword());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUseres();
    }


    @RequestMapping (value = "/{userId}", method = RequestMethod.DELETE)
    public List<User> deleteUser(@PathVariable String userId) throws NotFoundException {
        return userService.deleteUserById(userId);
    }
    @RequestMapping (value = "setNull/{userId}", method = RequestMethod.PUT)
    public List<Recipe> setNull(@PathVariable String userId) throws NotFoundException {
        return userService.setNull(userId);
    }
}