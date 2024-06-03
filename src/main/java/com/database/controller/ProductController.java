package com.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.entity.Products;
import com.database.repo.ProductRepo;
import com.database.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductRepo productRepository;

    @Autowired
    ProductService productService;

    @Operation(summary = "create a new product" , description = "add a new product in the database")
    @PostMapping("/Add_allProducts")
    public Products createData(@RequestBody Products entity) {
        productRepository.save(entity);
        return entity;
    }

    @GetMapping("/fetch_all_products")
    public List<Products> getAllProducts() {
        return productRepository.findAll();
        
    }
    
    @Operation(summary = "Using the user credentials and get product details ", description = "fetch the product detail using username & password")
    @GetMapping("/productsByProductId")
    public Products getProductsByProductsId(@RequestParam int productId) {
         return productService.fetchProductDetailsByUserProductId(productId);
    }
}
