package com.example.spring_api.repositories;

import com.example.spring_api.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
