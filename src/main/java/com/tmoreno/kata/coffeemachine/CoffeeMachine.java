package com.tmoreno.kata.coffeemachine;

public final class CoffeeMachine {

    private final CoffeeMaker coffeeMaker;

    public CoffeeMachine(CoffeeMaker coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
    }

    public void make(Order order) {
        if (order.getMoney() >= order.getDrink().getPrice()) {
            coffeeMaker.execute(order.toCommand());
        }
    }
}
