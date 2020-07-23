package com.enigma.restservice.repositories.impl;

import com.enigma.restservice.dto.TransactionSummary;
import com.enigma.restservice.entities.Transaction;
import com.enigma.restservice.repositories.TransactionRepositoryCustom;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionRepositoryCustomImpl implements TransactionRepositoryCustom{

    @Autowired
    private EntityManager entityManager;
    
    
    @Override
    public List<TransactionSummary> transactionSummary(LocalDate dateFrom, LocalDate dateTo) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TransactionSummary> query = builder.createQuery(TransactionSummary.class);
        Root<Transaction> root = query.from(Transaction.class);

        query
                .multiselect(
                        builder.sum(root.get("amount")),
                        root.get("typeEnum"),
                        builder.count(root)
        
                )
                .where(
                        builder.between(
                                builder.function(
                                        "DATE",
                                        Date.class,
                                        root.get("createDate")
                                ),
                                Date.valueOf(dateFrom),
                                Date.valueOf(dateTo)
                        )
                )
                .groupBy(root.get("typeEnum"));

        return entityManager.createQuery(query).getResultList();
    }
}
