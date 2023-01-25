package com.auth.converters;

import com.auth.dto.UserDto;
import com.auth.entities.Role;
import com.auth.entities.User;
import com.auth.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@Component
public class UserConverter {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public User dtoToEntity(UserDto userDto) {
        User u = new User();
        List<Role> roleList = new ArrayList<>();
        u.setId(0L);
        u.setUsername(userDto.getName());
        u.setEmail(userDto.getMail());
        u.setPassword(passwordEncoder.encode(userDto.getPass()));
        u.setRoles(roleList);
        return u;
    }

    public UserDto entityToDto(User user) {
        UserDto uDto = new UserDto();
        uDto.setId(user.getId())
                .setName(user.getUsername())
                .setRoles(getRole(user))
                .setMail(user.getEmail())
                .setPass("");
        return uDto;
    }

    @Transactional
    public String getRole (User user){
        return userService.findByUsername(user.getUsername()).get().getRoles().stream().map(Role::getName).collect(Collectors.joining(" "));
    }
}
