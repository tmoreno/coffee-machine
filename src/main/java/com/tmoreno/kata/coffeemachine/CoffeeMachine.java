package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public final class CoffeeMachine {

    private final CoffeeMaker coffeeMaker;

    public CoffeeMachine(CoffeeMaker coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
    }

    public void make(Order order) {
        if (order.getMoney().compareTo(order.getDrink().getPrice()) != -1) {
            coffeeMaker.execute(toCommand(order));
        }
        else {
            BigDecimal missingMoney = order.getDrink().getPrice().subtract(order.getMoney());
            coffeeMaker.execute("M:Not enough money. Missing " + missingMoney + " euros");
        }
    }

    private String toCommand(Order order) {
        if (order.getSugar() > 0) {
            return order.getDrinkCode() + ":" + order.getSugar() + ":0";
        }
        else {
            return order.getDrinkCode() + "::";
        }
    }
}
