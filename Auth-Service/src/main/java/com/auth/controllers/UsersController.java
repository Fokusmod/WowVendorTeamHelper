package com.auth.controllers;

import com.auth.converters.UserConverter;
import com.auth.dto.UserDto;
import com.auth.entities.User;
import com.auth.exceptions.ResourceNotFoundException;
import com.auth.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UsersController {

    private final UserService userService;
    private final UserConverter userConverter;

    @GetMapping
    public List<UserDto> allUsers() {
        return userService.getAll().stream().map(userConverter::entityToDto).collect(Collectors.toList());
    }

    @GetMapping("/{userName}")
    public UserDto findUserByName(@PathVariable String userName) {
        return userService.findByUsername(userName).map(userConverter::entityToDto).orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден"));
    }

    @PostMapping("/new")
    public void createNewUser(@RequestBody UserDto userDto){
        User newUser = userConverter.dtoToEntity(userDto);
        userService.createNewUser(newUser, userDto.getRoles());
    }

    @DeleteMapping("/{id}")
    public void delProducts(@PathVariable Long id){
        userService.deleteById(id);
    }
}
