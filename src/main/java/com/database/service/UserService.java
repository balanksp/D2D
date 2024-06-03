package com.database.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.entity.Products;
import com.database.entity.UserInfo;
import com.database.repo.ProductRepo;
import com.database.repo.UserInfoRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    UserInfoRepo userInfoRepo;

    @Autowired
    ProductRepo productRepo;


    public Products getProductByUserInfoProductId(String name,String password) {
        UserInfo userProductId = userInfoRepo.findProductIdByNameAndPassword(name, password);
    //   userProductId.getProductId();
      System.out.println(userProductId.getProductId()+"get the product id from user info===============");

      Products finalDetails = productRepo.findByProductId(userProductId.getProductId());
      System.out.println(finalDetails+"================");
        return finalDetails;

        

    }
}
