package com.example.product.controller;


import com.example.product.entity.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping(path="/product")
public class ProductController {


    @Autowired
    ProductService productService;
    @PostMapping(path="/addProduct")
    public @ResponseBody String addProduct (@RequestParam Long id, @RequestBody Product product) {
        return productService.addProduct(product,id);
    }
    @GetMapping(path="/getProductByIdByUserId")
    public @ResponseBody Product getProductByIdByUserId(@RequestParam Long productId, @RequestParam Long userId) {
        return productService.findProductById(productId, userId);
    }

    @DeleteMapping(path="/deleteProductById")
    public @ResponseBody String deleteProductById(@RequestParam Long productId, @RequestParam Long userId) {
       return productService.deleteProductById(productId, userId);
    }

    @GetMapping(path="/getAllProduct")
    public @ResponseBody List<Product> getAllProduct(@RequestParam Long userId) {
        return productService.getAllProducts(userId);
    }


    @PatchMapping(path="/updateProductBySeller")
    public @ResponseBody String updateProductBySeller (@RequestParam Long userId, @RequestParam Long productId,@RequestBody Product product) {
        return productService.updateProduct(userId, productId, product);
    }

    @DeleteMapping(path="/deleteAllProduct")
    public @ResponseBody String deleteAllProduct (@RequestParam Long userId) {
        return  productService.deleteAll(userId);
    }


    @GetMapping("/getProductById")
    public @ResponseBody Optional<Product> getProductById(Long productId){
        return productService.getByIdOnly(productId);
    }

    @PutMapping (path="/updateProductByCart")
    public void updateProductByCart(@RequestBody Product product) {
        productService.updateProductByCart(product);
    }





}
