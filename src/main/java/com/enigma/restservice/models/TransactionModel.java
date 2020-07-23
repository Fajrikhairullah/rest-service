package com.enigma.restservice.models;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TransactionModel {
    
    private Integer id;
    @NotNull
    private long amount;
    @NotNull
    private TypeEnum typeEnum;
    @NotBlank(message ="description cannot be empty")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "TransactionModel{" 
                + "id=" + id 
                + ", amount=" + amount 
                + ", typeEnum=" + typeEnum 
                + ", description=" + description + '}';
    }

   
    
    
}
