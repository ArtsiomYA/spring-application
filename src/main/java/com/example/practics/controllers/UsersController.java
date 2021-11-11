package com.example.practics.controllers;

import com.example.practics.dto.UserDto;
import com.example.practics.models.Users;
import com.example.practics.repository.UsersRepository;
import com.example.practics.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
@Validated
public class UsersController {
    private final UserService userService;
    private final UsersRepository usersRepository;

    @GetMapping
    public ResponseEntity<List<Users>> getUsers() {
        return ResponseEntity.ok(usersRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Users> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.of(usersRepository.findById(id));
    }

    @PostMapping
    public Users createUser(@Valid @RequestBody UserDto user) {
        return userService.createUser(user);
    }
    @PutMapping("{id}")
    public Users updateUser(@PathVariable("id") Users userFromDB, @RequestBody Users user) {
        BeanUtils.copyProperties(user, userFromDB, "id");
        return usersRepository.save(userFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Users user) {
        usersRepository.delete(user);
    }
}
