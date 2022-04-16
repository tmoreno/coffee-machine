package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public final class Order {

    private final Drink drink;
    private final int sugar;
    private final BigDecimal money;

    public Order(Drink drink, int sugar, BigDecimal money) {
        this.drink = drink;
        this.sugar = sugar;
        this.money = money;
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

    public BigDecimal getMoney() {
        return money;
    }
}
