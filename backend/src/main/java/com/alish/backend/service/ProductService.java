package com.alish.backend.service;


import com.alish.backend.model.Product;
import com.alish.backend.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts() {
        log.info("printing all Products");
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        log.info("retrieving a Product by id:" + id);
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product user) {
        log.info("Creating new Product:" + user.getName());
        return productRepository.save(user);
    }
    public Product createDefaultProduct(){
        log.info("creating a default Product");
        return productRepository.save(Product.defaultProduct());
    }
    public Product updateProduct(Long id, Product productDetails) {
        log.info("updating a Product"+id);
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(productDetails.getName());
            product.setDescribtion(productDetails.getDescribtion());
            product.setQuantity(productDetails.getQuantity());
            product.setWeight(productDetails.getWeight());
            product.setPrice(productDetails.getPrice());
            product.setNumber(productDetails.getNumber());
            product.setMetric(productDetails.getMetric());
            product.setSize(productDetails.getSize());
            log.info(id+"product successfully updated");
            return productRepository.save(product);
        }
        log.error(id+":product not found");
        return null;
    }

    public void deleteProduct(Long id) {
        log.info("deleting product by id:"+id);
        productRepository.deleteById(id);
    }
}
