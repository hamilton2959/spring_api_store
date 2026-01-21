package com.example.spring_api.mappers;
import com.example.spring_api.dtos.RegisterUserRequest;
import com.example.spring_api.dtos.UpdateUserRequest;
import com.example.spring_api.mappers.UserMapper;

import com.example.spring_api.dtos.UserDto;
import com.example.spring_api.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "Spring")
//@Mapper(componentModel = "String")
public interface UserMapper {
    //@Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}
