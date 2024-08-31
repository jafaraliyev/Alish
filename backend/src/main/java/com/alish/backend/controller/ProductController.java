package com.alish.backend.controller;

import com.alish.backend.dto.ProductDTO;
import com.alish.backend.model.Product;
import com.alish.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        Product createdProduct = productService.createProduct(Product.builder()
                .name(productDTO.getName())
                .describtion(productDTO.getDescribtion())
                .quantity(productDTO.getQuantity())
                .weight(productDTO.getWeight())
                .price(productDTO.getPrice())
                .number(productDTO.getNumber())
                .metric(productDTO.getMetric())
                .size(productDTO.getSize()).build());
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
    @PostMapping("/default")
    public ResponseEntity<Product> createProduct(){
        Product defaultProduct = productService.createDefaultProduct();
        return new ResponseEntity<>(defaultProduct, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductId(@PathVariable long id){
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product ProductDetails) {
        Product updatedProduct = productService.updateProduct(id, ProductDetails);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
