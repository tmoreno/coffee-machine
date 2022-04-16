package com.tmoreno.kata.coffeemachine;

public final class Order {

    private final Drink drink;
    private final int sugar;
    private final double money;

    public Order(Drink drink, int sugar, double money) {
        this.drink = drink;
        this.sugar = sugar;
        this.money = money;
    }

    public Drink getDrink() {
        return drink;
    }

    public double getMoney() {
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
