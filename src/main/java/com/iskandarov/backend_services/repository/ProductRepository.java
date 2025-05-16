package com.iskandarov.backend_services.repository;

import com.iskandarov.backend_services.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
