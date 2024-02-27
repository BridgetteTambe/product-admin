package com.bree.com.services;

import com.bree.com.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Product save(Product product);

    List<Product> saveAll(List<Product> products);

//    Set <Product> update(Product product);

    void deleteAll();

    void deleteById(String id);

    List<Product> findAll();
    Page<Product> findAll(Pageable pageable);

    Product findById(String id);

    List<Product> findAllNotProcessedProducts();

    List<Product> updateProductInBulk(List<Product> products);
}
