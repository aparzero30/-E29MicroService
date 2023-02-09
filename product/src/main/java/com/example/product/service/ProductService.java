package com.example.product.service;


import com.example.product.entity.Product;
import com.example.product.entity.User;
import com.example.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static String baseUrl =  "http://localhost:8081/user/";

    public String addProduct(Product product, Long userId){

        String url = baseUrl+"findUser?id="+userId;
        User user = restTemplate.getForObject(url, User.class);

        if(user == null || !user.getRole().toLowerCase().contains("seller")) {return "cant add";}

        product.setUserId(Math.toIntExact(userId));
        productRepository.save(product);
        return "product added";
    }

    public Product findProductById(Long productId, Long userId){

        String url = baseUrl+"findUser?id="+userId;
        User user = restTemplate.getForObject(url, User.class);

        if(user == null || !user.getRole().toLowerCase().contains("seller")) {return null;}
        Optional<Product> product = productRepository.findById(productId);

        if( product.isPresent()){
            Product foundProduct= product.get();

            if(foundProduct.getUserId()==userId){

                return foundProduct;
            }
                return null;

        }
        return null;
    }

    public String deleteProductById(Long productId, Long userId){

        String url = baseUrl+"findUser?id="+userId;
        User user = restTemplate.getForObject(url, User.class);

        if(user == null || !user.getRole().toLowerCase().contains("seller")) {return "cant delete";}
        Optional<Product> product = productRepository.findById(productId);

        if( product.isPresent()){
            Product foundProduct= product.get();

            if(foundProduct.getUserId()==userId){

                productRepository.delete(foundProduct);
                return "deleted";
            }
            return "cant delete";

        }
        return  "cant delete";
    }


    public  List<Product> getAllProducts(Long userId){
        String url = baseUrl+"findUser?id="+userId;
        User user = restTemplate.getForObject(url, User.class);

        if(user == null || !user.getRole().toLowerCase().contains("seller")) {return null;}

        return productRepository.findByUserId(userId);

    }

    public  String updateProduct(Long userId, Long productId, Product product){

        if(productRepository.findById(productId)==null){
            return "product not existing";
        }
        product.setProductId(Math.toIntExact(productId));
        return addProduct(product, userId);

    }

    public Optional<Product> getByIdOnly(long productId){
        return productRepository.findById(productId);
    }


    public void updateProductByCart(Product product){
        productRepository.save(product);
    }




    @Transactional
    public String deleteAll(Long userId){

        String url = baseUrl+"findUser?id="+userId;
        User user = restTemplate.getForObject(url, User.class);

        if(user == null || !user.getRole().toLowerCase().contains("seller")) {return "cant delete";}

        productRepository.deleteByUserId(userId);

        return "all products deleted";
    }







}
