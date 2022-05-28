package com.example.ZTP_PROJ6.controllers;


import com.example.ZTP_PROJ6.beans.Book;
import com.example.ZTP_PROJ6.beans.Recipe;
import com.example.ZTP_PROJ6.beans.User;
import com.example.ZTP_PROJ6.exceptions.NotFoundException;
import com.example.ZTP_PROJ6.repositorys.RecipeRepository;
import com.example.ZTP_PROJ6.repositorys.UserRepository;
import com.example.ZTP_PROJ6.requests.CreateBookRequest;
import com.example.ZTP_PROJ6.requests.RecipeRequest;
import com.example.ZTP_PROJ6.requests.UserRequest;
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
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecipeRepository recipeRepository;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }


//    @PostMapping("/createNewUser")
//    public List<User> addUser(@RequestBody UserRequest request) {
//         return userService.addUser(request.getUsername(), request.getPassword());
//    }
//    @GetMapping("/allUsers")
//    public List<User> findAllUsers() {
//        return userRepository.findAll();
//    }

//    @RequestMapping(value = "/username", method = RequestMethod.GET)
//    @ResponseBody
//    public String currentUserName(Principal principal) {
//        return principal.getName();
//    }
    @GetMapping
    public List<Recipe> getAllRecipes() {return dashboardService.getAllRecipes(); }

    @GetMapping("/all")
    public List<Recipe> getAllUsersRecipes(){
        return dashboardService.getAllUsersRecipes();
    }


    @PostMapping
    public List<Recipe> addRecipe(@RequestBody RecipeRequest request) {
        return dashboardService.addRecipe(request.getName(), request.getDescription(), request.getIngredients(), request.getLevel());
    }
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Book> getBooks(){
//        return dashboardService.getAllBooks();
//    }


//    @RequestMapping (method = RequestMethod.POST)
//    public List<Book> addNewBook(@RequestBody CreateBookRequest createBookRequest){
//        return dashboardService.addBook( createBookRequest.getTitle(), createBookRequest.getAuthor(), createBookRequest.getYear());
//    }
//    @RequestMapping (value = "/{bookId}", method = RequestMethod.DELETE)
//    public List<Book> deleteBook(@PathVariable String bookId) throws NotFoundException {
//        return dashboardService.deleteBookById(bookId);
//    }
//
//    @RequestMapping (value = "/{bookId}", method = RequestMethod.GET)
//    public Book getBookById(@PathVariable String bookId) throws NotFoundException {
//        return dashboardService.getBookById(bookId);
//    }
}
