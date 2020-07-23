package com.enigma.restservice.repositories;

import com.enigma.restservice.dto.TransactionSummary;
import java.time.LocalDate;
import java.util.List;

public interface TransactionRepositoryCustom {
    
    public List<TransactionSummary> transactionSummary (LocalDate dateFrom, LocalDate dateTo);
}
