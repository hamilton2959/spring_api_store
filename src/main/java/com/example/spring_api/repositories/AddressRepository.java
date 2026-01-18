package com.example.spring_api.repositories;

import com.example.spring_api.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}