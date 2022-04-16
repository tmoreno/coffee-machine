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
        coffeeMachine.make(new Order(Drink.TEA, 0));

        verify(coffeeMaker).execute("T::");
    }
}
