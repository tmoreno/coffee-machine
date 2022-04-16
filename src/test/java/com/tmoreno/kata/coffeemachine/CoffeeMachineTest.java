package com.tmoreno.kata.coffeemachine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CoffeeMachineTest {

    @Mock
    private CoffeeMaker coffeeMaker;

    @InjectMocks
    private CoffeeMachine coffeeMachine;

    @Test
    public void should_send_command_to_coffee_maker_for_a_tea_order() {
        coffeeMachine.make(new Order(Drink.TEA, 0, false), Drink.TEA.getPrice());

        verify(coffeeMaker).execute("T::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_an_extra_hot_tea_order() {
        coffeeMachine.make(new Order(Drink.TEA, 0, true), Drink.TEA.getPrice());

        verify(coffeeMaker).execute("Th::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_a_coffee_order() {
        coffeeMachine.make(new Order(Drink.COFFEE, 0, false), Drink.COFFEE.getPrice());

        verify(coffeeMaker).execute("C::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_an_extra_hot_coffee_order() {
        coffeeMachine.make(new Order(Drink.COFFEE, 0, true), Drink.COFFEE.getPrice());

        verify(coffeeMaker).execute("Ch::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_a_chocolate_order() {
        coffeeMachine.make(new Order(Drink.CHOCOLATE, 0, false), Drink.CHOCOLATE.getPrice());

        verify(coffeeMaker).execute("H::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_an_extra_hot_chocolate_order() {
        coffeeMachine.make(new Order(Drink.CHOCOLATE, 0, true), Drink.CHOCOLATE.getPrice());

        verify(coffeeMaker).execute("Hh::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_an_orange_juice_order() {
        coffeeMachine.make(new Order(Drink.ORANGE_JUICE, 0, false), Drink.ORANGE_JUICE.getPrice());

        verify(coffeeMaker).execute("O::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_order_with_one_sugar() {
        coffeeMachine.make(new Order(Drink.CHOCOLATE, 1, false), Drink.CHOCOLATE.getPrice());

        verify(coffeeMaker).execute("H:1:0");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_order_with_two_sugar() {
        coffeeMachine.make(new Order(Drink.TEA, 2, false), Drink.TEA.getPrice());

        verify(coffeeMaker).execute("T:2:0");
    }

    @Test
    public void should_send_not_enough_money_command() {
        BigDecimal payment = Drink.TEA.getPrice().subtract(new BigDecimal("0.1"));

        coffeeMachine.make(new Order(Drink.TEA, 2, false), payment);

        verify(coffeeMaker).execute("M:Not enough money. Missing 0.1 euros");
    }
}
