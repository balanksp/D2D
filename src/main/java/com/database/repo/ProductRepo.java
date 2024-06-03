package com.database.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.context.annotation.ApplicationScope;

import com.database.entity.Products;

@ApplicationScope
public interface ProductRepo extends JpaRepository<Products,Integer>  {

    public Products findByProductId(int productId);

    
}
