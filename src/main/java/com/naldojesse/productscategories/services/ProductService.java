package com.naldojesse.productscategories.services;


import com.naldojesse.productscategories.models.Product;
import com.naldojesse.productscategories.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }
}
