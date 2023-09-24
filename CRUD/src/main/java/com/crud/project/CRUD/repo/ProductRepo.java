package com.crud.project.CRUD.repo;

import com.crud.project.CRUD.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
