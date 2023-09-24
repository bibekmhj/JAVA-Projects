package com.crud.project.CRUD.controller;

import com.crud.project.CRUD.entity.Product;
import com.crud.project.CRUD.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
       return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/productById/{id}")
    public Product findById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return "Deleted " +id;
    }
}
