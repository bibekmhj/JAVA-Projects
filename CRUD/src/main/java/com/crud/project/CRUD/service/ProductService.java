package com.crud.project.CRUD.service;

import com.crud.project.CRUD.entity.Product;
import com.crud.project.CRUD.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepo.saveAll(products);
    }

    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    public Product getProductById(int id){
        return productRepo.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return productRepo.findByName(name);
    }

    public String deleteProduct(int id){
        productRepo.deleteById(id);
        return "Deleted " +id;
    }

    public Product updateProduct(Product product){
        Product existingproduct = productRepo.findById(product.getId()).orElse(null);
        existingproduct.setName(product.getName());
        existingproduct.setPrice(product.getPrice());
        existingproduct.setQuantity(product.getQuantity());
        return productRepo.save(existingproduct);
    }
}
