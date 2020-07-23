package com.enigma.restservice.services.impl;

import com.enigma.restservice.dto.StockSummary;
import com.enigma.restservice.entities.Stock;
import com.enigma.restservice.exceptions.EntityNotFoundException;
import com.enigma.restservice.repositories.StockRepository;
import com.enigma.restservice.services.StockService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class StockServiceImpl extends CommonServiceImpl<Stock, Integer> implements StockService{

    @Autowired
    private StockRepository repository;

    @Override
    public Stock save(Stock entity) {
        return repository.save(entity);
    }

    @Override
    public Stock removeById(Integer id) {
        Stock entity = findById(id);
        repository.delete(entity);

        return entity;

    }

    @Override
    public Stock findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException();
        });
    }

    @Override
    public Page<Stock> findAll(Stock entity, int page, int size, Sort.Direction direction) {
        Sort s = Sort.Direction.DESC.equals(direction) ? Sort.by("id").descending() : Sort.by("id");
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return repository.findAll(Example.of(entity, matcher), PageRequest.of(page, size, s));

    }
    @Override
    public List<StockSummary> stockSummary(){
        return repository.stockSummary();
    }

    @Override
    protected JpaRepository<Stock, Integer> getRepository() {
       return repository;
    }
}
