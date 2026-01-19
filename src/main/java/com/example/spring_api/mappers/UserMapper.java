package com.example.spring_api.mappers;
import com.example.spring_api.mappers.UserMapper;

import com.example.spring_api.dtos.UserDto;
import com.example.spring_api.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
//@Mapper(componentModel = "String")
public interface UserMapper {
    //@Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
}
