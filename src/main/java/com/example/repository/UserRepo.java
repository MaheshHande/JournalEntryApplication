package com.example.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entity.User;


public interface UserRepo extends MongoRepository<User,ObjectId>{
    User findByUserName(String userName);
        
    }

