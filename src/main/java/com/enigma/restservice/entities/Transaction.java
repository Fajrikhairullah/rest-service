package com.enigma.restservice.entities;

import com.enigma.restservice.models.TypeEnum;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.Table;

@Table(name = "transaction")
@Entity
public class Transaction extends AbstractEntity {

    @Column(nullable = false)
    private long amount;

    @Enumerated(EnumType.STRING)
    private TypeEnum typeEnum;

    @Column(nullable = false)
    private String description;
    
    public Transaction(long amount, TypeEnum typeEnum, String description) {
        this.amount = amount;
        this.typeEnum = typeEnum;
        this.description = description;
    }

    public Transaction() {
        
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" + "amount=" + amount + ", typeEnum=" + typeEnum + ", description=" + description + '}';
    }

    
}
