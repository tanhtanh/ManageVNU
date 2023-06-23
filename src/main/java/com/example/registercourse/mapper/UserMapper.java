package com.example.registercourse.mapper;

import com.example.registercourse.dto.UsersDto;
import com.example.registercourse.models.Users;

public class UserMapper {
    public static UsersDto toUserDto(Users users) {
        UsersDto tmp = new UsersDto();
        tmp.setId(users.getId());
        tmp.setEmail(users.getEmail());
        tmp.setUsername(users.getUsername());
        tmp.setRole(users.getRole());
        return tmp;
    }
}
