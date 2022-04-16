package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public enum Drink {
    COFFEE("C", new BigDecimal("0.6")),
    TEA("T", new BigDecimal("0.4")),
    CHOCOLATE("H", new BigDecimal("0.5"));

    private final String code;
    private final BigDecimal price;

    Drink(String code, BigDecimal price) {
        this.code = code;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
