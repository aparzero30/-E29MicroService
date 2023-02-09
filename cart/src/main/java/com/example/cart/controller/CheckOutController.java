package com.example.cart.controller;


import com.example.cart.entity.CheckOut;
import com.example.cart.entity.Product;
import com.example.cart.repository.CheckOutRepository;
import com.example.cart.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/cart")
public class CheckOutController {


    @Autowired
    CheckOutService checkOutService;

    @PostMapping(path="/addToCart")
    public @ResponseBody String addProduct (@RequestParam Long userId, @RequestBody Product product) {
        return  checkOutService.addToCart(userId, product);
    }

    @DeleteMapping(path="/deleteAllInCart")
    public @ResponseBody String deleteAllProduct (@RequestParam Long userId) {
        return  checkOutService.deleteAll(userId);
    }

    @GetMapping(path="/getAllCheckOut")
    public @ResponseBody List<CheckOut> getAllProduct(@RequestParam Long userId) {
        return  checkOutService.getAllCheckOuts(userId);
    }

    @PatchMapping("/updateCheckOut")
    public @ResponseBody String updateProduct(@RequestParam Long userId, @RequestBody CheckOut checkOut){
        return checkOutService.updateCheckOut(userId, checkOut);
    }

}
