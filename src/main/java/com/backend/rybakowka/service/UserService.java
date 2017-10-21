package com.backend.rybakowka.service;

import com.backend.rybakowka.dto.UserDto;
import com.backend.rybakowka.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface UserService {

    List<UserDto> getListOfUsers();

    UserDto findUserById(Long id);

    User findUserByLogin(String login);

    UserDto register(UserDto userDto);

    UserDto update(UserDto userDto);

    UserDto delete(UserDto userDto);

}
