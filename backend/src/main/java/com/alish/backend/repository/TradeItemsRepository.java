package com.alish.backend.repository;

import com.alish.backend.model.Trade;
import com.alish.backend.model.TradeItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeItemsRepository extends JpaRepository<TradeItems, Long> {
}
