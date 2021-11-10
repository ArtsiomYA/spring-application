package com.example.practics.service;

import com.example.practics.dto.UserDto;
import com.example.practics.models.Users;
import com.example.practics.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;

    public Users createUser(UserDto userDto) {
        var listUsers = usersRepository.findAllByLogin(userDto.getLogin());
        if (!listUsers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        var user = new Users();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return usersRepository.save(user);
    }
}
