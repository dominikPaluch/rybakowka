package com.backend.rybakowka.service.impl;

import com.backend.rybakowka.dto.UserDto;
import com.backend.rybakowka.exception.UserException;
import com.backend.rybakowka.model.User;
import com.backend.rybakowka.repository.UserRepository;
import com.backend.rybakowka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getListOfUsers() {
        return userRepository.findAll().stream()
                .map(User::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findUserById(Long id) {
        return Optional.ofNullable(userRepository.findOne(id))
                .orElseThrow(
                        () -> new UserException("User doesn't exixts!"))
                .toDto();
    }

    @Override
    public User findUserByLogin(String login) {
        return userRepository
                .findBylogin(login)
                .orElseThrow(
                        () -> new UserException("There is no user with given login!")
                );
    }

    @Override
    public UserDto register(UserDto userDto) {
        User user = new User(userDto);
        return userRepository.saveAndFlush(user).toDto();
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = new User(findUserById(userDto.getId()));

        user.setAccessLevelEnum(userDto.getAccessLevelEnum());
        user.setPassword(userDto.getPassword());
        user.setConfirmed(userDto.isConfirmed());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setPhone(userDto.getPhone());

        return userRepository.save(user).toDto();
    }

    @Override
    public UserDto delete(UserDto userDto) {
        User user = new User(findUserById(userDto.getId()));

        user.setDeleted(true);
        return userRepository.save(user).toDto();
    }

//    @Override
//    public ResponseEntity delete(Long id) {
//        userRepository.delete(id);
//        return ResponseEntity.ok().build();
//    }

}
