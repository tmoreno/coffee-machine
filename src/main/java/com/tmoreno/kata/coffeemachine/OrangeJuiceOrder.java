package com.tmoreno.kata.coffeemachine;

import java.math.BigDecimal;

public final class OrangeJuiceOrder extends Order {
    public OrangeJuiceOrder() {
        super("O", new BigDecimal("0.6"), 0, false);
    }
}
