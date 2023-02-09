package com.example.cart.service;


import com.example.cart.entity.CheckOut;
import com.example.cart.entity.Product;
import com.example.cart.entity.User;
import com.example.cart.repository.CheckOutRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

@Service
public class CheckOutService {

   @Autowired
    CheckOutRepository checkOutRepository;


    @Autowired
    private RestTemplate restTemplate;

    private static String baseUrl =  "http://localhost:8081/user/findUser?id=";
    private static String baseUrl1 = "http://localhost:8082/product/getProductById?productId=";

   public String addToCart(Long userId, Product product){



       String url = baseUrl+userId;
       String url1 = baseUrl1+product.getProductId();
       User user = restTemplate.getForObject(url, User.class);
       Product product1 = restTemplate.getForObject(url1, Product.class);

       if(user == null || !user.getRole().toLowerCase().contains("customer")) {return "cant add";}
       if(product1 == null ) {return "cant add";}

       if(product.getQuantity()>product1.getQuantity()){
           return "Out of Stock";
       }




       CheckOut checkOut = new CheckOut();
       checkOut.setProductId(Math.toIntExact(product1.getProductId()));
       checkOut.setUserId(Math.toIntExact(userId));
       checkOut.setProductName(product1.getProductName());
       checkOut.setProductQuantity(product.getQuantity());
       checkOut.setPrice(product1.getPrice());
       checkOut.setProductTotal(product1.getPrice()*product.getQuantity());
       product1.setQuantity(product1.getQuantity()- product.getQuantity());


       RestTemplate restTemplate1 = new RestTemplate();
       org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);


       HttpEntity<Product> request = new HttpEntity<>(product1, headers);
       restTemplate1.exchange(
               "http://localhost:8082/product/updateProductByCart",
               HttpMethod.PUT,
               request,
               Void.class);

       checkOutRepository.save(checkOut);


       return "added";
   }


    @Transactional
    public String deleteAll(Long userId){

        String url = baseUrl+userId;
        User user = restTemplate.getForObject(url, User.class);

        if(user == null || !user.getRole().toLowerCase().contains("customer")) {return "cant execute";}


        checkOutRepository.deleteByUserId(userId);

        return "all items remove";
    }


    public List<CheckOut> getAllCheckOuts(Long userId){
        String url = baseUrl+userId;
        User user = restTemplate.getForObject(url, User.class);

        if(user == null || !user.getRole().toLowerCase().contains("customer")) {return null;}

        return checkOutRepository.findByUserId(userId);

    }


    public String updateCheckOut(Long userId,  CheckOut checkOut){


       Optional<CheckOut> ck = checkOutRepository.findById(Long.valueOf(checkOut.getCheckOutId()));

       if(ck == null){
           return "error";
       }


        String url = baseUrl+userId;
        User user = restTemplate.getForObject(url, User.class);
        String url1 = baseUrl1+checkOut.getProductId();
        Product product = restTemplate.getForObject(url1, Product.class);

        if(user == null || !user.getRole().toLowerCase().contains("customer")) {return null;}

        if(checkOut.getCheckOutId()<product.getQuantity()){
            return "out of stock";
        }



        if(ck.isPresent()){
            CheckOut founndCheckOut = ck.get();
            product.setQuantity(product.getQuantity()+founndCheckOut.getProductQuantity());
            founndCheckOut.setProductQuantity(checkOut.getProductQuantity());
            founndCheckOut.setProductTotal(checkOut.getProductQuantity()*founndCheckOut.getPrice());
            checkOutRepository.save(founndCheckOut);
            if(founndCheckOut.getProductQuantity()==0){
                checkOutRepository.delete(founndCheckOut);
            }


        }

        System.out.println(product.getQuantity());

        product.setQuantity(product.getQuantity()-checkOut.getProductQuantity());

        RestTemplate restTemplate1 = new RestTemplate();
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<Product> request = new HttpEntity<>(product, headers);
        restTemplate1.exchange(
                "http://localhost:8082/product/updateProductByCart",
                HttpMethod.PUT,
                request,
                Void.class);







       return "added";
    }







}
