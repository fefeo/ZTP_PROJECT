package com.example.ZTP_PROJ6.services;

import com.example.ZTP_PROJ6.beans.Book;
import com.example.ZTP_PROJ6.beans.Role;
import com.example.ZTP_PROJ6.beans.User;
import com.example.ZTP_PROJ6.exceptions.ForbiddenException;
import com.example.ZTP_PROJ6.exceptions.NotFoundException;
import com.example.ZTP_PROJ6.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    HashMap<String, String> Users = new HashMap<>();

    public UserService(){
        //Przykładowi użytkownicy
        Users.put("admin", "admin123");
        Users.put("czytelnik11","czyt0077");
        Users.put("czytelnik12","czesc1234");
        Users.put("czytelnik13","omen991");
        Users.put("czytelnik14","Siek1122");
    }

    public List<User> getAllUseres() {
        return userRepository.findAll();
    }

    public List<User> addUser(String username, String password) {
        if(userRepository.existsByLogin(username) == null) {
            userRepository.save(new User(User.idCreator(), username, password, Role.USER));
            return userRepository.findAll();
        }
        throw new ForbiddenException("User with this login alredy exists!");
    }
    public List<User> deleteUserById(String id) throws NotFoundException {
            if(userRepository.existsById(id)) {
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
}
