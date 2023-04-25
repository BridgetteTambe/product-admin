package com.bree.com.web;

import com.bree.com.models.Product;
import com.bree.com.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:4200/"})
public class ProductResource {
    private static final Logger LOG = LoggerFactory.getLogger(ProductResource.class);
    private final ProductService productService;


    @PostMapping("/products")
    public ResponseEntity<Product> save(@RequestBody Product product) throws Exception {
        LOG.info("Rest Request to save product : {}", product);
        if (product.getId() != null) {
            throw new Exception("Can not create new product with id." + product.getId());
        }
//        The below line makes sure that every new product set processed to false
        product.setProcessed(false);
        Product save = this.productService.save(product);
        return ResponseEntity.ok(save);
    }

    @PostMapping("/products/bulk/{adminId}")
    public ResponseEntity<List<Product>> saveBulk(@RequestBody List<Product> products, @PathVariable String adminId) throws Exception {
        LOG.info("Rest Request to save products :{}", products);
        products = products.stream().map(product -> {
            product.setAdminId(adminId);
            //        The below line makes sure that every new product set processed to false
            product.setProcessed(false);
            return product;
        }).collect(Collectors.toList());

        List<Product> save = this.productService.saveAll(products);
        return ResponseEntity.ok(save);
    }

    @PutMapping("/products")
    public ResponseEntity<Product> update(@RequestBody Product product) throws Exception {
        LOG.info("Rest Request to update product : {}", product);
        if (product.getId() == null) {
            throw new Exception("Can not update product with id.null");
        }
        Product save = this.productService.save(product);
        return ResponseEntity.ok(save);
    }

    @PutMapping("/products/bulk")
    public ResponseEntity<List<Product>> updateBulk(@RequestBody List<Product> products) throws Exception {
        LOG.info("Rest Request to updateBulk products : {}", products);
        List<Product> save = this.productService.saveAll(products);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/products")
    public ResponseEntity delete(@RequestBody Product product) throws Exception {
        LOG.info("Rest Request to delete product : {}", product);
        if (product.getId() == null) {
            throw new Exception("Can not delete product with id.null");
        }
        this.productService.delete(product);
        return ResponseEntity.ok(HttpStatus.resolve(200));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteById(@PathVariable String id) throws Exception {
        LOG.info("Rest Request to delete product by id : {}", id);
        if (id == null) {
            throw new Exception("Can not delete product with id.null");
        }
        this.productService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.resolve(200));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable String id) throws Exception {
        LOG.info("Rest Request to find all product");
        Product product = this.productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll() throws Exception {
        LOG.info("Rest Request to find all product");
        List<Product> all = this.productService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/products/pageable")
    public ResponseEntity<Page<Product>> findAll(Pageable pageable) throws Exception {
        LOG.info("Rest Request to find all product by pageable : {} ", pageable);
        Page<Product> all = this.productService.findAll(pageable);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/products/not-process")
    public ResponseEntity<List<Product>> findAllNotProcessedProducts(
            @RequestHeader(name = "X-USERNAME", required = false) String userName) throws Exception {
        LOG.info("Rest Request to find all product by findAllNotProcessedProducts : {} ", userName);
        List<Product> all = this.productService.findAllNotProcessedProducts();
        return ResponseEntity.ok(all);
    }
}
