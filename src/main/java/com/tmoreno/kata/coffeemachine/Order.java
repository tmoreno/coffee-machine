package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public final class Order {

    private final Drink drink;
    private final int sugar;
    private final boolean extraHot;

    public Order(Drink drink, int sugar, boolean extraHot) {
        this.drink = drink;
        this.sugar = sugar;
        this.extraHot = extraHot;
    }

    public String getDrinkCode() {
        return drink.getCode();
    }

    public BigDecimal getDrinkPrice() {
        return drink.getPrice();
    }

    public int getSugar() {
        return sugar;
    }

    public boolean isExtraHot() {
        return extraHot;
    }
}
