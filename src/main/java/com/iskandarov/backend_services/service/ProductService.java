package com.iskandarov.backend_services.service;

import com.iskandarov.backend_services.dto.ProductCreateRequest;
import com.iskandarov.backend_services.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
  Product createProduct(ProductCreateRequest product);

  List<Product> getAllProducts();

  Optional<Product> getProductById(Long id);

  Product updateProduct(Long id, ProductCreateRequest updatedProduct);

  void deleteProduct(Long id);

  boolean existsById(Long id);
}
