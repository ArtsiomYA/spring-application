package com.example.practics.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotBlank(message = "Login is mandatory")
    @NotNull
    private String login;
    @NotBlank(message = "Password isn't valid")
    @NotNull
    private String password;
}
