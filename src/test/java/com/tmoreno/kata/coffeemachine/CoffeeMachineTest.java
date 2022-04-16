package com.tmoreno.kata.coffeemachine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CoffeeMachineTest {

    @Mock
    private CoffeeMaker coffeeMaker;

    @InjectMocks
    private CoffeeMachine coffeeMachine;

    @Test
    public void should_send_command_to_coffee_maker_for_one_tea_order() {
        coffeeMachine.make(new Order(Drink.TEA, 0, Drink.TEA.getPrice()));

        verify(coffeeMaker).execute("T::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_one_coffee_order() {
        coffeeMachine.make(new Order(Drink.COFFEE, 0, Drink.COFFEE.getPrice()));

        verify(coffeeMaker).execute("C::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_one_chocolate_order() {
        coffeeMachine.make(new Order(Drink.CHOCOLATE, 0, Drink.CHOCOLATE.getPrice()));

        verify(coffeeMaker).execute("H::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_order_with_one_sugar() {
        coffeeMachine.make(new Order(Drink.CHOCOLATE, 1, Drink.CHOCOLATE.getPrice()));

        verify(coffeeMaker).execute("H:1:0");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_order_with_two_sugar() {
        coffeeMachine.make(new Order(Drink.TEA, 2, Drink.TEA.getPrice()));

        verify(coffeeMaker).execute("T:2:0");
    }
}
