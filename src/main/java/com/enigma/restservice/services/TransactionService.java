package com.enigma.restservice.services;

//import com.enigma.restservice.dto.TransactionSummary;
import com.enigma.restservice.dto.TransactionSummary;
import com.enigma.restservice.entities.Transaction;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;


public interface TransactionService {
    
    public Transaction save(Transaction entity);

    public Transaction removeById(Integer id);

    public Transaction findById(Integer id);

    public Page<Transaction> findAll(Transaction entity, int page, int size, Sort.Direction direction);

    public List<TransactionSummary> transactionSummary (Year year, Month month, Integer date);

    
}

    

