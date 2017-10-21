//package com.backend.rybakowka.service.impl;
//
////import com.backend.rybakowka.model.CurrentUser;
//import com.backend.rybakowka.model.CurrentUser;
//import com.backend.rybakowka.model.User;
//import com.backend.rybakowka.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Service
//public class UserDetailServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
//
//    private UserService userService;
//
//    @Autowired
//    public UserDetailServiceImpl(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        User userDto = userService.findUserByLogin(login);
//
//        return new CurrentUser(userDto);
//    }
//}
