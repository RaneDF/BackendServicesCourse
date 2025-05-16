package com.iskandarov.backend_services.service;

import com.iskandarov.backend_services.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
  Product createProduct(Product product);

  List<Product> getAllProducts();

  Optional<Product> getProductById(Long id);

  Product updateProduct(Long id, Product updatedProduct);

  void deleteProduct(Long id);

  boolean existsById(Long id);
}
