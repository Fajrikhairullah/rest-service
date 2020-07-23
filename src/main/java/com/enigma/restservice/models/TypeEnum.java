package com.enigma.restservice.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeEnum {
     PURCHASE("PURCHASE"), SALE("SALE");

    private final String value;

    private TypeEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static TypeEnum forValue(String value) {
        System.out.println("#" + value);

        return TypeEnum.valueOf(value);
    }

}
