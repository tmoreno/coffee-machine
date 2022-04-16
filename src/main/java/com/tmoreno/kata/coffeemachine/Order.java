package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public final class Order {

    private final Drink drink;
    private final int sugar;

    public Order(Drink drink, int sugar) {
        this.drink = drink;
        this.sugar = sugar;
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
}
