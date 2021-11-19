package com.example.practics.service;

import com.example.practics.dto.UserDto;
import com.example.practics.exceptions.BadRequestException;
import com.example.practics.models.Users;
import com.example.practics.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;

    public Users createUser(UserDto userDto) {
        List<Users> listUsers = usersRepository.findAllByLogin(userDto.getLogin());
        if (!listUsers.isEmpty()) {
            throw new BadRequestException("A user with this login already exists");

        }
        Users user = new Users();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return usersRepository.save(user);
    }

    public Users updateUser(Users userFromDB, UserDto user) {
        userFromDB.setLogin(user.getLogin());
        userFromDB.setPassword(user.getPassword());
        return usersRepository.save(userFromDB);
    }
}
