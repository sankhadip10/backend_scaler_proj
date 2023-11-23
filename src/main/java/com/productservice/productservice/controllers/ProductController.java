package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.services.FakeStoreProductService;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

//    @Autowired
    private ProductService productService;
   //Controller Injection
    ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    //localhost:8080/products/123
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id")Long id){
       //call the FakeStoreProductService getProductById() method
//        return "Scaler || Product fetched with id: "+id;
        return productService.getProductById(id);
    }
    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }
    @DeleteMapping("/{id}")
    public void deleteProductById(){

    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
//        return null;
    }
    public void updateProductById(){

    }
}

//3 ways of Dependency injection
//1.Controller Injection
//2.Field Injection

