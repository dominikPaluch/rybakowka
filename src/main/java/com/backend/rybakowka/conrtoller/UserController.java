package com.backend.rybakowka.conrtoller;

import com.backend.rybakowka.dto.UserDto;
import com.backend.rybakowka.model.User;
import com.backend.rybakowka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<UserDto> getListOfUser() {
        return userService.getListOfUsers();
    }

    @GetMapping(value = "/{id}")
    public UserDto findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    //?
    @GetMapping(value = "find")
    public User findUserByLogin(@RequestParam("login") String login){
        return userService.findUserByLogin(login);
    }

    @PostMapping()
    public @ResponseBody
    UserDto register(@RequestBody @Valid UserDto userDto) {
        userService.register(userDto);

        return userDto;
    }

    @PutMapping(value = "/update/{id}")
    public @ResponseBody
    UserDto update(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        userService.update(userDto);
        return userDto;
    }

    @PutMapping(value = "/delete/{id}")
    public @ResponseBody
    UserDto delete(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        userService.delete(userDto);
        return userDto;
    }

//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity delete(@PathVariable("id") Long id) {
//        return userService.delete(id);
//    }
}
