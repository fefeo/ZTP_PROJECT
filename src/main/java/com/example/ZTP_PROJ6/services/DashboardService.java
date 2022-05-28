package com.example.ZTP_PROJ6.services;

import com.example.ZTP_PROJ6.beans.Recipe;
import com.example.ZTP_PROJ6.beans.User;
import com.example.ZTP_PROJ6.exceptions.NotFoundException;
import com.example.ZTP_PROJ6.repositorys.RecipeRepository;
import com.example.ZTP_PROJ6.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.example.ZTP_PROJ6.beans.Book;

import java.util.ArrayList;
import java.util.List;


@Service
public class DashboardService {
    private Book Book;
    private User user;
    private List<Book> Books = new ArrayList<>();
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    UserRepository userRepository;


     public DashboardService(){
        Books.add(new Book(Book.idCreator(),"Pamiętnik Pułku Jazdy Wołyńskiej", "Karol Różycki", 2022));
        Books.add(new Book(Book.idCreator(),"Przygody Tomka Sawyera", "Mark Twain", 1876));
        Books.add(new Book(Book.idCreator(),"Dzieci z Bullerbyn ", "Astrid Lindgren", 1947));
    }

    public List<Book> getAllBooks() {
        Object auth = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(auth);
         return Books;
    }

    public List<Recipe> getAllUsersRecipes() {
//        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
          //User user = userRepository.getById("7c70e9e4-5007-463b-9cde-35d24bcd3f6b");
        return recipeRepository.findAllByUser_Id("7c70e9e4-5007-463b-9cde-35d24bcd3f6b");
    }


    public Book getBookById(String id) throws NotFoundException {
        for (Book book : Books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        throw new NotFoundException("Book not found!");
    }

    public List<Book> deleteBookById(String id) throws NotFoundException {
        for (Book book : Books) {
            if (book.getId().equals(id)) {
                this.Book = book;
                Books.remove(book);
                return Books;
            }
        }
        throw new NotFoundException("Book not found!");
    }

    public List<Book> addBook(String title, String author, int year) {
        Books.add(new Book(Book.idCreator(), title, author, year));
        return Books;
        }
}
