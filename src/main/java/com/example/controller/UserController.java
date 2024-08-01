package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.JournalEntry;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

     // Create User
     @PostMapping("/createuser")
     public User createuser(@RequestBody User user) {
      userService.SaveUser(user);
      return user; 
        
     }
     

    // Get All User
    @GetMapping("/getuser")
    public List<User>getUser() {
        return userService.GetAllUser();
        
    }


    // Find User By UserName
    @PutMapping("/Finduserbyid")
    public User FindUserName(@PathVariable User user) {
      User UserinDb= userService.FindUserName(user.getUserName());
      if(UserinDb != null ){
        UserinDb.setUserName(user.getUserName());
        UserinDb.setPassword(user.getPassword());
        userService.SaveUser(UserinDb);
      }
      return user;



    }
}

   
    
   
   

    
    
   



