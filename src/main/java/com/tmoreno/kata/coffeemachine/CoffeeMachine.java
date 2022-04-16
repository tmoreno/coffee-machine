package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public final class CoffeeMachine {

    private final CoffeeMaker coffeeMaker;

    public CoffeeMachine(CoffeeMaker coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
    }

    public void make(Order order, BigDecimal payment) {
        if (payment.compareTo(order.getDrinkPrice()) != -1) {
            coffeeMaker.execute(toCommand(order));
        }
        else {
            BigDecimal missingPayment = order.getDrinkPrice().subtract(payment);
            coffeeMaker.execute("M:Not enough money. Missing " + missingPayment + " euros");
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
