package com.example.user.service;


import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public String addUser(User user){
        userRepository.save(user);
        return "user created!";
    }

    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }



    public String delete(Long id){

        Optional<User> user = findUserById(id);

        if( user.isPresent()){
            User foundUser = user.get();


            if(foundUser.getRole().toLowerCase().contains("seller")){
                String url =  "http://localhost:8082/product/deleteAllProduct?userId="+foundUser.getUserId();
                restTemplate.delete(url);
            }
            else{
                String url2 =  "http://localhost:8083/cart/deleteAllInCart?userId="+foundUser.getUserId();
                restTemplate.delete(url2);
            }





            userRepository.delete(foundUser);


            return  "deleted";

        }
        return "does not exist";
    }


    public String update(Long id, User user){

        Optional<User> user1 = findUserById(id);
        if( user1.isPresent()){


            User foundUser = user1.get();
            foundUser.setUserName(user.getUserName());
            foundUser.setPassword(user.getPassword());
            foundUser.setRole(user.getRole());
            userRepository.save(foundUser);
            return  "updated";

        }
        return "does not exist";
    }









}
