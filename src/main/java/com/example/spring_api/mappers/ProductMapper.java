package com.example.spring_api.mappers;

import com.example.spring_api.dtos.ProductDto;
import com.example.spring_api.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface ProductMapper {
    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);
}
