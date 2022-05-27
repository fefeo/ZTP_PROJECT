package com.example.ZTP_PROJ3.security;

import com.example.ZTP_PROJ3.beans.User;
import com.example.ZTP_PROJ3.exceptions.NotFoundException;
import com.example.ZTP_PROJ3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService){
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String login){
        User user;
        try {
            System.out.println(login);
            user = userService.getUserByLogin(login);
            System.out.println(user.getLogin() + user.getPass() + user.getRole());
        } catch (Exception e) {
            System.out.println(login+" NOT FOUND");
            throw new UsernameNotFoundException("Username "+login+" not found!");
        }
        System.out.println(user.getRole());
        return new UserPrincipal(user);
    }
}
