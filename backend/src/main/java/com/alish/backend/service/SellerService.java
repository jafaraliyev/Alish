package com.alish.backend.service;

import com.alish.backend.model.Seller;
import com.alish.backend.repository.SellerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;
    public List<Seller> getAllSellers() {
        log.info("printing all sellers");
        return sellerRepository.findAll();
    }

    public Seller getSellerById(Long id) {
        log.info("retrieving a seller by id:" + id);
        return sellerRepository.findById(id).orElse(null);
    }

    public Seller createSeller(Seller user) {
        log.info("Creating new seller:" + user.getName());
        return sellerRepository.save(user);
    }
    public Seller createDefaultSeller(){
        log.info("creating a default seller");
        return sellerRepository.save(Seller.defaultSeller());
    }
    public Seller updateSeller(Long id, Seller userDetails) {
        log.info("updating a seller"+id);
        Seller seller = sellerRepository.findById(id).orElse(null);
        if (seller != null) {
            seller.setName(userDetails.getName());
            seller.setTradesHistory(userDetails.getTradesHistory());
            seller.setPassword(userDetails.getPassword());
            seller.setVoen(userDetails.getVoen());
            log.info(id+"seller successfully updated");
            return sellerRepository.save(seller);
        }
        log.error(id+":seller not found");
        return null;
    }

    public void deleteSeller(Long id) {
        log.info("deleting seller by id:"+id);
        sellerRepository.deleteById(id);
    }
}
