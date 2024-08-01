package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.entity.User;
import com.example.repository.UserRepo;

@Component
public class UserService {

    @Autowired
    private UserRepo userRepo;


      // Create User Entries 
public User SaveUser(@RequestBody User user){
    return  userRepo.save(user);
    
}

       // GetAll User Entries
public List<User>GetAllUser(){
    return userRepo.findAll();

}
  
    // Find User By UserName
public User FindUserName(String userName){
   return userRepo.findByUserName(userName);
   
}


}
