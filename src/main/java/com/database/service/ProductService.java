package com.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.entity.Products;
import com.database.repo.ProductRepo;


@Service
public class ProductService {

   
    @Autowired
    ProductRepo productRepo;

    public Products fetchProductDetailsByUserProductId(int productId){

        // Products productDetails = productRepo.findByProductId(productId);

        // return productDetails;

        return productRepo.findByProductId(productId);

         


    }
    
}
