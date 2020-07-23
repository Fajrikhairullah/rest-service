package com.enigma.restservice.repositories;

//import com.enigma.restservice.dto.TransactionSummary;
import com.enigma.restservice.entities.Transaction;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>, TransactionRepositoryCustom {

//    public List<TransactionSummary> transactionSummary(LocalDate dateFrom, LocalDate dateTo);

//    public List<Transaction> findByNameContaining(String name);


}
