package com.enigma.restservice.dto;

import com.enigma.restservice.models.TypeEnum;
import java.math.BigDecimal;

public class TransactionSummary {

    private long amount;
    private TypeEnum typeEnum;
    private long count;

    public TransactionSummary() {
    }
    
    public TransactionSummary(long amount, TypeEnum typeEnum, long count) {
        this.amount = amount;
        this.typeEnum = typeEnum;
        this.count = count;
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

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}
