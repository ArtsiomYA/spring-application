package com.example.practics.repository;

import com.example.practics.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByLogin(String login);
    Users findUsersById(Long userId);

}
