package com.alish.backend.service;

import com.alish.backend.model.TradeItems;
import com.alish.backend.repository.TradeItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TradeItemsService {
    @Autowired
    private TradeItemsRepository tradeItemsRepository;

    public List<TradeItems> getAllTradeItems() {
        log.info("printing all tradeItemss");
        return tradeItemsRepository.findAll();
    }

    public TradeItems getTradeItemsById(Long id) {
        log.info("retrieving a tradeItems by id:" + id);
        return tradeItemsRepository.findById(id).orElse(null);
    }

    public TradeItems createTradeItems(TradeItems tradeItems) {
        log.info("Creating new tradeItems:" + tradeItems.getTIId());
        return tradeItemsRepository.save(tradeItems);
    }
    public TradeItems createDefaultTradeItems(){
        log.info("creating a default tradeItems");
        return tradeItemsRepository.save(TradeItems.defaultTradeItems());
    }
    public TradeItems updateTradeItems(Long id, TradeItems tradeItemsDetails) {
        log.info("updating a tradeItems"+id);
        TradeItems tradeItems = tradeItemsRepository.findById(id).orElse(null);
        if (tradeItems != null) {
            tradeItems.setTrade(tradeItemsDetails.getTrade());
            tradeItems.setPrice(tradeItemsDetails.getPrice());
            tradeItems.setQuantity(tradeItemsDetails.getQuantity());
            tradeItems.setProduct(tradeItemsDetails.getProduct());
            log.info(id+"tradeItems successfully updated");
            return tradeItemsRepository.save(tradeItems);
        }
        log.error(id+":tradeItems not found");
        return null;
    }

    public void deleteTradeItems(Long id) {
        log.info("deleting tradeItems by id:"+id);
        tradeItemsRepository.deleteById(id);
    }
}
