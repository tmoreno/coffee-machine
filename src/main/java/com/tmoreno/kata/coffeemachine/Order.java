package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public abstract class Order {

    private final String drinkCode;
    private final BigDecimal drinkPrice;
    private final int sugar;
    private final boolean extraHot;

    public Order(String drinkCode, BigDecimal drinkPrice, int sugar, boolean extraHot) {
        this.drinkCode = drinkCode;
        this.drinkPrice = drinkPrice;
        this.sugar = sugar;
        this.extraHot = extraHot;
    }

    public String getDrinkCode() {
        return drinkCode;
    }

    public BigDecimal getDrinkPrice() {
        return drinkPrice;
    }

    public int getSugar() {
        return sugar;
    }

    public boolean isExtraHot() {
        return extraHot;
    }
}
