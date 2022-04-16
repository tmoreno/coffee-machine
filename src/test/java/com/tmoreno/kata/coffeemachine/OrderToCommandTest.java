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

    @Test
    public void should_crate_command_for_one_coffee_order() {
        Order order = new Order(Drink.COFFEE, 0);

        String command = order.toCommand();

        assertThat(command).isEqualTo("C::");
    }

    @Test
    public void should_crate_command_for_one_chocolate_order() {
        Order order = new Order(Drink.CHOCOLATE, 0);

        String command = order.toCommand();

        assertThat(command).isEqualTo("H::");
    }

    @Test
    public void should_crate_command_for_order_with_one_sugar() {
        Order order = new Order(Drink.CHOCOLATE, 1);

        String command = order.toCommand();

        assertThat(command).isEqualTo("H:1:0");
    }

    @Test
    public void should_crate_command_for_order_with_two_sugar() {
        Order order = new Order(Drink.TEA, 2);

        String command = order.toCommand();

        assertThat(command).isEqualTo("T:2:0");
    }
}
