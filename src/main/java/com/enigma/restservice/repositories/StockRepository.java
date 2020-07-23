package com.enigma.restservice.repositories;

import com.enigma.restservice.entities.Stock;
import com.enigma.restservice.dto.StockSummary;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer>, StockRepositoryCustom{
//    public List<Stock> findByNameContaining(String name);
    
}
