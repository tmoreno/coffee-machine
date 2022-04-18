package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public final class CoffeeMachine {

    private final CoffeeMaker coffeeMaker;
    private final BeverageQuantityChecker beverageQuantityChecker;
    private final EmailNotifier emailNotifier;
    private final OrderRepository orderRepository;

    public CoffeeMachine(
        CoffeeMaker coffeeMaker,
        BeverageQuantityChecker beverageQuantityChecker,
        EmailNotifier emailNotifier,
        OrderRepository orderRepository
    ) {
        this.coffeeMaker = coffeeMaker;
        this.beverageQuantityChecker = beverageQuantityChecker;
        this.emailNotifier = emailNotifier;
        this.orderRepository = orderRepository;
    }

    public void make(Order order, BigDecimal payment) {
        if (beverageQuantityChecker.isEmpty(order.getDrinkCode().getCode())) {
            emailNotifier.notifyMissingDrink(order.getDrinkCode().getCode());
            coffeeMaker.execute("M:Not enough " + order.getDrinkCode().getHumanReadable() + ".");
            return;
        }

        if (payment.compareTo(order.getDrinkPrice()) == -1) {
            BigDecimal missingPayment = order.getDrinkPrice().subtract(payment);
            coffeeMaker.execute("M:Not enough money. Missing " + missingPayment + " euros");
            return;
        }
        
        coffeeMaker.execute(toCommand(order));

        orderRepository.save(order);
    }

    private String toCommand(Order order) {
        String drinkCode = order.getDrinkCode().getCode();

        if (order.isExtraHot()) {
            drinkCode += "h";
        }

        if (order.getSugar() > 0) {
            return drinkCode + ":" + order.getSugar() + ":0";
        }
        else {
            return drinkCode + "::";
        }
    }
}
