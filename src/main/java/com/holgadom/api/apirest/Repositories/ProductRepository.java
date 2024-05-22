package com.holgadom.api.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.holgadom.api.apirest.Entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
