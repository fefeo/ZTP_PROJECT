package com.example.ZTP_PROJ3.controllers;


import com.example.ZTP_PROJ3.beans.Book;
import com.example.ZTP_PROJ3.beans.User;
import com.example.ZTP_PROJ3.exceptions.NotFoundException;
import com.example.ZTP_PROJ3.repositorys.RecipeRepository;
import com.example.ZTP_PROJ3.repositorys.UserRepository;
import com.example.ZTP_PROJ3.requests.CreateBookRequest;
import com.example.ZTP_PROJ3.requests.UserRequest;
import com.example.ZTP_PROJ3.services.DashboardService;
import com.example.ZTP_PROJ3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    @PostMapping("/createNewUser")
    public User addUser(@RequestBody UserRequest request) {
         return userService.addUser(request.getUsername(), request.getPassword());
    }
    @GetMapping("/allUsers")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

//    @RequestMapping(value = "/username", method = RequestMethod.GET)
//    @ResponseBody
//    public String currentUserName(Principal principal) {
//        return principal.getName();
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBooks(){
        return dashboardService.getAllBooks();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUseres(){
        return userService.getAllUseres();
    }

    @RequestMapping (method = RequestMethod.POST)
    public List<Book> addNewBook(@RequestBody CreateBookRequest createBookRequest){
        return dashboardService.addBook( createBookRequest.getTitle(), createBookRequest.getAuthor(), createBookRequest.getYear());
    }
    @RequestMapping (value = "/{bookId}", method = RequestMethod.DELETE)
    public List<Book> deleteBook(@PathVariable String bookId) throws NotFoundException {
        return dashboardService.deleteBookById(bookId);
    }

    @RequestMapping (value = "/{bookId}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable String bookId) throws NotFoundException {
        return dashboardService.getBookById(bookId);
    }
}
