package com.database.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "User_information")
public class UserInfo {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private int productId;
    }
