package com.iskandarov.backend_services.controller;

import com.iskandarov.backend_services.dto.ProductCreateRequest;
import com.iskandarov.backend_services.entity.Product;
import com.iskandarov.backend_services.exception.ProductNotFoundException;
import com.iskandarov.backend_services.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody ProductCreateRequest product) {
    Product savedProduct = productService.createProduct(product);
    return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = productService.getAllProducts();
    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    Product product = productService.getProductById(id)
            .orElseThrow(() -> new ProductNotFoundException(id));
    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(
          @PathVariable Long id, @RequestBody ProductCreateRequest updatedProduct) {
    Product updated = productService.updateProduct(id, updatedProduct);
    return new ResponseEntity<>(updated, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id) {
    if (!productService.existsById(id)) {
      throw new ProductNotFoundException(id);
    }
    productService.deleteProduct(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}