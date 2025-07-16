package ru.aston.user_service.service.dto;

import ru.aston.user_service.repository.entity.User;

public class UserDto {

    private Long id;
    private String name;
    private String email;
    private User.Role role;
}
