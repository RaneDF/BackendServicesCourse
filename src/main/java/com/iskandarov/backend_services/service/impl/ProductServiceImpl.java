package com.iskandarov.backend_services.service.impl;

import com.iskandarov.backend_services.entity.Product;
import com.iskandarov.backend_services.repository.ProductRepository;
import com.iskandarov.backend_services.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Optional<Product> getProductById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public Product updateProduct(Long id, Product updatedProduct) {
    Optional<Product> existingProduct = productRepository.findById(id);
    if (existingProduct.isPresent()) {
      updatedProduct.setId(id);
      return productRepository.save(updatedProduct);
    }
    return null;
  }

  @Override
  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public boolean existsById(Long id) {
    return productRepository.existsById(id);
  }
}
