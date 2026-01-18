package com.example.spring_api.mappers;
import com.example.spring_api.mappers.UserMapper;

import com.example.spring_api.dtos.UserDto;
import com.example.spring_api.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "String")
public interface UserMapper {
    UserDto toDto(User user);
}
