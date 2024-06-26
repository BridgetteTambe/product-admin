package com.bree.com.resources;

import com.bree.com.models.Admin;
import com.bree.com.models.Product;
import com.bree.com.services.ProductService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4201/", "http://localhost:4201", "http://localhost:4201", "https://product-admin-view.vercel.app/", "https://product-customer-view.vercel.app/"})
public class ProductResource {
    private static final Logger LOG = LoggerFactory.getLogger(ProductResource.class);

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product> save(@RequestBody Product product) throws Exception {
        LOG.info("Rest Request to save product : {}", product);
        if (product.getId() != null) {
            throw new Exception("Can not create new product with id." + product.getId());
        }
        product.setProcessed(false);
        Product save = this.productService.save(product);
        return ResponseEntity.ok(save);
    }

    @PutMapping("/products")
    public ResponseEntity<Product> update(@RequestBody Product product) throws Exception {
        LOG.info("Rest Request to save products : {}", product);
        if (product.getId() == null) {
            throw new Exception("Cant update a product with a null Id.");
        }
        product.setProcessed(false);
        Product save = this.productService.save(product);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id) {
        LOG.info("Rest request to get products by Id : {}", id);
        Product product = this.productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll() throws Exception {
        LOG.info("Rest Request to get all products");
        List<Product> getAll = this.productService.findAll();
        return ResponseEntity.ok(getAll);
    }

    @DeleteMapping("/products")
    public ResponseEntity deleteAll() throws Exception {
        LOG.info("Rest Request to delete all product");
        this.productService.deleteAll();
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteById(@PathVariable String id) throws Exception {
        LOG.info("Rest Request to delete products by id : {} ", id);
        if (id == null) {
            throw new Exception("Cant delete products with a null id");
        }
        this.productService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.resolve(200));
    }


    @Description("this will be called by the customer service to get all unprocessed products")
    @GetMapping("/products/not-process")
    public ResponseEntity<List<Product>> findAllNotProcessedProducts() throws Exception {
        LOG.info("Rest Request to get products unprocess products : {}");
        List<Product> allNotProcessedProducts = this.productService.findAllNotProcessedProducts();
        return ResponseEntity.ok(allNotProcessedProducts);
    }

    @Description("this will be called by the customer service to update products that have been processed")
    @PutMapping("/products/bulk-update")
    public ResponseEntity<List<Product>> updateProductInBulk(@RequestBody List<Product> products) throws Exception {
        LOG.info("Rest Request to get product in bulk: {}", products);
        if (products == null) {
            throw new Exception("Cant return empty products");
        }
        List<Product> bulkProduct = this.productService.saveAll(products);
        return ResponseEntity.ok(bulkProduct);
    }


}
