package com.example.practics.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
