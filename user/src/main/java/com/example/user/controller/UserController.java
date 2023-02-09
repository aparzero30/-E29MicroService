package com.example.user.controller;


import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@RequestMapping(path="/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping(path="/createUser")
    public @ResponseBody String addUser (@RequestBody User user) {
        return userService.addUser(user);
    }

    @PatchMapping(path="/updateUser")
    public @ResponseBody String updateUser (@RequestParam Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping(path="/deleteUser")
    public @ResponseBody String deleteUser (@RequestParam Long id) {
        return userService.delete(id);
    }


    @GetMapping(path="/findUser")
    public @ResponseBody Optional<User> findStudent (@RequestParam Long id) {
        return userService.findUserById(id);
    }






}
