package com.example.spring_api.controllers;

import com.example.spring_api.dtos.ProductDto;
import com.example.spring_api.entities.Product;
import com.example.spring_api.mappers.ProductMapper;
import com.example.spring_api.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProducts(
            @RequestParam(name = "CategoryId", required = false) Byte CategoryId
    ) {
        List<Product> products;
        //check if we do have our product category
        if (CategoryId != null) {
            products = productRepository.findByCategoryId(CategoryId);
        }else {
            products = productRepository.findAllWithCategory();
        }
        return products.stream().map(productMapper::toDto).toList();
    }
}
