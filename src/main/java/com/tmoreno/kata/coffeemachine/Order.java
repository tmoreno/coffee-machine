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

    public Drink getDrink() {
        return drink;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public String toCommand() {
        if (sugar > 0) {
            return drink.getCode() + ":" + sugar + ":0";
        }
        else {
            return drink.getCode() + "::";
        }
    }
}
