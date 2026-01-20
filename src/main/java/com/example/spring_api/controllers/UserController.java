package com.example.spring_api.controllers;

import com.example.spring_api.dtos.UserDto;
import com.example.spring_api.mappers.UserMapper;
import com.example.spring_api.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public Iterable<UserDto> getAllUsers(
            @RequestHeader(name = "x-auth-token") String authToken,
            @RequestParam(required = false, defaultValue = "", name = "sort") String sortBy
    ) {
        System.out.println(authToken);

        if (!Set.of("name", "email").contains(sortBy))
            sortBy =  "name";

        return userRepository.findAll(Sort.by(sortBy))
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable long id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return ResponseEntity.notFound().build();
        }

        //return new ResponseEntity<>(user, HttpStatus.OK);
        //var userDto = new UserDto(user.getId(), user.getName(), user.getEmail());
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
