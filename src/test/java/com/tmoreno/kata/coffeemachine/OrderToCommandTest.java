package com.tmoreno.kata.coffeemachine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderToCommandTest {

    @Test
    public void should_crate_command_for_one_tea_order() {
        Order order = new Order(Drink.TEA, 0);

        String command = order.toCommand();

        assertThat(command).isEqualTo("T::");
    }
}
