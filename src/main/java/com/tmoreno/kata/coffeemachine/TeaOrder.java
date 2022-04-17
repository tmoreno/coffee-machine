package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public final class TeaOrder extends Order {
    public TeaOrder(int sugar, boolean extraHot) {
        super(DrinkCode.TEA, new BigDecimal("0.4"), sugar, extraHot);
    }
}
