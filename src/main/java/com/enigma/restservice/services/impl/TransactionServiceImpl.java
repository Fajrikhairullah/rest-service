package com.enigma.restservice.services.impl;

//import com.enigma.restservice.dto.TransactionSummary;
import com.enigma.restservice.dto.TransactionSummary;
import com.enigma.restservice.entities.Transaction;
import com.enigma.restservice.exceptions.EntityNotFoundException;
import com.enigma.restservice.repositories.TransactionRepository;
import com.enigma.restservice.services.TransactionService;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;
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

@Transactional
@Service
public class TransactionServiceImpl implements TransactionService{
    
    @Autowired
    private TransactionRepository transRepository;

    @Override
    public Transaction save(Transaction entity) {
        return transRepository.save(entity);
    }

    @Override
    public Transaction removeById(Integer id) {
        Transaction entity = findById(id);
        transRepository.delete(entity);

        return entity;

    }

    @Override
    public Transaction findById(Integer id) {
        return transRepository.findById(id).orElseThrow(() -> {
            return new EntityNotFoundException();
        });
    }

    @Override
    public Page<Transaction> findAll(Transaction entity, int page, int size, Sort.Direction direction) {
        Sort s = Sort.Direction.DESC.equals(direction) ? Sort.by("id").descending() : Sort.by("id");
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return transRepository.findAll(Example.of(entity, matcher), PageRequest.of(page, size, s));
    }

    @Override
    public List<TransactionSummary> transactionSummary(Year year, Month month, Integer date) {
        LocalDate dateFrom = LocalDate.of(year.getValue(), 1, 1);
        LocalDate dateTo = LocalDate.of(year.getValue(), 12, 1);

        if (month != null) {
            dateFrom = dateFrom.withMonth(month.getValue());
            dateTo = dateTo.withMonth(month.getValue());
        }

        if (date != null) {
            dateFrom = dateFrom.withDayOfMonth(1);
            dateTo = dateTo.withDayOfMonth(date);
        } else {
            dateFrom = dateFrom.withDayOfMonth(1);
            dateTo = dateTo.with(TemporalAdjusters.lastDayOfMonth());
        }
        List<TransactionSummary> enities = transRepository.transactionSummary(dateFrom, dateTo);

        return enities;

    }

//    @Override
//    protected JpaRepository<Transaction, Integer> getRepository() {
//        return transRepository;
//    }

    
}

    

