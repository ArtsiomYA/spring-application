package com.example.practics.controllers;

import com.example.practics.models.Users;
import com.example.practics.repository.UsersRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    @GetMapping("{id}")
    public Users getUser(@PathVariable("id") Users user) {
        return user;
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return usersRepository.save(user);
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
