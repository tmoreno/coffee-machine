package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public enum Drink {
    COFFEE("C", new BigDecimal("0.6")),
    EXTRA_HOT_COFFEE("Ch", new BigDecimal("0.6")),
    TEA("T", new BigDecimal("0.4")),
    EXTRA_HOT_TEA("Th", new BigDecimal("0.4")),
    CHOCOLATE("H", new BigDecimal("0.5")),
    EXTRA_HOT_CHOCOLATE("Hh", new BigDecimal("0.5")),
    ORANGE_JUICE("O", new BigDecimal("0.6"));

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
