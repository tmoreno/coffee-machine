package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public final class ChocolateOrder extends Order {
    public ChocolateOrder(int sugar, boolean extraHot) {
        super(DrinkCode.CHOCOLATE, new BigDecimal("0.5"), sugar, extraHot);
    }
}
