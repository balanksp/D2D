package com.database.controller;

import org.springframework.web.bind.annotation.RestController;

import com.database.entity.Products;
import com.database.entity.UserInfo;
import com.database.repo.ProductRepo;
import com.database.repo.UserInfoRepo;
import com.database.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoRepo userInfoRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    UserService userService;

    @PostMapping("/addUserInfo")
    public UserInfo addUserInfo(UserInfo userInfo) {
        log.info("UserInfoController::addUserInfo{} added the user");
        userInfo.setId(UUID.randomUUID().toString());
        return userInfoRepo.save(userInfo);
    }

    @GetMapping("/getAllUsers")
    public List<UserInfo> getAllUser() {
    log.info("UserInfoController::getAllUser{} fetch the user");

    return userInfoRepo.findAll();
    }


    @GetMapping("/getProductIdByNameAndPassword")
    public UserInfo getProductIdByNamePassword(@RequestParam String name, @RequestParam String password) {
       
     UserInfo userdetails = userInfoRepo.findProductIdByNameAndPassword(name, password);
      
    // return  userdetails.getProductId();

return userdetails;
    }

      // by above getProductId need to fetch that ProductInfo
      @Operation(summary = "get list of the products by userInfo" , description = "fetch the list of products from the database")

@GetMapping("/getProductsByProductId")
    public Products getProductByUserInfoProductId(@RequestParam String name, @RequestParam String password) {
       
      return userService.getProductByUserInfoProductId(name, password);

    }

    
}
