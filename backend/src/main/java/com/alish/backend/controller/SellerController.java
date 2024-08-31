package com.alish.backend.controller;

import com.alish.backend.dto.SellerDTO;
import com.alish.backend.model.Seller;
import com.alish.backend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/sellers")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @GetMapping("/all")
    public ResponseEntity<List<Seller>> getAllSellers() {
        List<Seller> sellers = sellerService.getAllSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Seller> createSeller(@RequestBody SellerDTO sellerDTO) {
        Seller createdSeller = sellerService.createSeller(Seller.builder()
                .name(sellerDTO.getName())
                .password(sellerDTO.getPassword())
                .username(sellerDTO.getUsername())
                .voen(sellerDTO.getVoen())
                .build());
        return new ResponseEntity<>(createdSeller, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerId(@PathVariable long id){
        Seller seller = sellerService.getSellerById(id);
        return new ResponseEntity<>(seller, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Long id, @RequestBody Seller SellerDetails) {
        Seller updatedSeller = sellerService.updateSeller(id, SellerDetails);
        if (updatedSeller != null) {
            return new ResponseEntity<>(updatedSeller, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        sellerService.deleteSeller(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
