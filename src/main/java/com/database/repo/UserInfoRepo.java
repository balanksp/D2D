package com.database.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.context.annotation.ApplicationScope;

import com.database.entity.UserInfo;

@ApplicationScope
public interface UserInfoRepo extends MongoRepository<UserInfo,String>{

    public Optional<UserInfo> findByProductId(int productId);

    public UserInfo findProductIdByNameAndPassword(String name,String password );
    
}
