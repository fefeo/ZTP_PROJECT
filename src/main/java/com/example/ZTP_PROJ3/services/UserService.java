package com.example.ZTP_PROJ3.services;

import com.example.ZTP_PROJ3.beans.Book;
import com.example.ZTP_PROJ3.beans.Role;
import com.example.ZTP_PROJ3.beans.User;
import com.example.ZTP_PROJ3.exceptions.NotFoundException;
import com.example.ZTP_PROJ3.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
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

    public User addUser(String username, String password) {
        return userRepository.save(new User(User.idCreator(), username, password, Role.USER));
    }

    public User getUserByLogin(String login) {
        if (Users.get(login) == null) {
            return null;
        } else if ("admin".equals(login)) {
            return new User(User.idCreator(), login, Users.get(login), Role.ADMIN);
        } else {
            return new User(User.idCreator(), login, Users.get(login), Role.USER);
        }
    }
}
