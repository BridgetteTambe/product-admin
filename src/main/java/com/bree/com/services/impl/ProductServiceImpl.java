package com.bree.com.services.impl;

import com.bree.com.models.Product;
import com.bree.com.repositories.ProductRepository;
import com.bree.com.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    /**
     * @param product
     * @return
     */
    @Override
    public Product save(Product product) {
        LOG.info("Request to save product: {}", product);
        return this.productRepository.save(product);
    }

    /**
     * @param products
     * @return
     */
    @Override
    public List<Product> saveAll(List<Product> products) {
        LOG.info("Request to save all products: {}", products);
        return this.productRepository.saveAll(products);
    }

    /**
     * @param product
     * @return
     */
    @Override
    public Product update(Product product) {
        LOG.info("Request to update product: {}", product);
        return this.productRepository.save(product);
    }

    /**
     * @param product
     */
    @Override
    public void delete(Product product) {
        LOG.info("Request to delete product: {}", product);
        this.productRepository.delete(product);
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(String id) {
        LOG.info("Request to delete  product by id: {}", id);
        this.productRepository.deleteById(id);
    }


    /**
     * @param id
     * @return
     */
    @Override
    public Product findById(String id) {
        LOG.info("Request to find  product by id: {}", id);
        return this.productRepository.findById(id).orElse(null);
    }


    /**
     * @return
     */
    @Override
    public List<Product> findAll() {
        LOG.info("Request to find  products");
        return this.productRepository.findAll();
    }

    /**
     * @param pageable
     * @return
     */
    @Override
    public Page<Product> findAll(Pageable pageable) {
        LOG.info("Request to find  products: {}", pageable);
        return this.productRepository.findAll(pageable);
    }

    /**
     * @return
     */
    @Override
    public List<Product> findAllNotProcessedProducts() {
        LOG.info("Request to find  product not process");
        return productRepository.findAllByProcessedFalseOrProcessedNull();
    }
}
