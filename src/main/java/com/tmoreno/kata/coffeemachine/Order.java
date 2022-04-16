package com.tmoreno.kata.coffeemachine;

public final class Order {

    private final Drink drink;
    private final int sugar;

    public Order(Drink drink, int sugar) {
        this.drink = drink;
        this.sugar = sugar;
    }

    public String toCommand() {
        return drink.getCode() + "::";
    }
}
