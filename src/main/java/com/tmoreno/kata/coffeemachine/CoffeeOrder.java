package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public final class CoffeeOrder extends Order {
    public CoffeeOrder(int sugar, boolean extraHot) {
        super("C", new BigDecimal("0.6"), sugar, extraHot);
    }
}
