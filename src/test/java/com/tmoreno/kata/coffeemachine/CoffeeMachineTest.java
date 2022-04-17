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

    private static final BigDecimal TEA_PRICE = new BigDecimal("0.4");
    private static final BigDecimal COFFEE_PRICE = new BigDecimal("0.6");
    private static final BigDecimal CHOCOLATE_PRICE = new BigDecimal("0.5");
    private static final BigDecimal ORANGE_JUICE_PRICE = new BigDecimal("0.6");

    @Mock
    private CoffeeMaker coffeeMaker;

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private CoffeeMachine coffeeMachine;

    @Test
    public void should_send_command_to_coffee_maker_for_a_tea_order() {
        coffeeMachine.make(new TeaOrder(0, false), TEA_PRICE);

        verify(coffeeMaker).execute("T::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_an_extra_hot_tea_order() {
        coffeeMachine.make(new TeaOrder(0, true), TEA_PRICE);

        verify(coffeeMaker).execute("Th::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_a_coffee_order() {
        coffeeMachine.make(new CoffeeOrder(0, false), COFFEE_PRICE);

        verify(coffeeMaker).execute("C::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_an_extra_hot_coffee_order() {
        coffeeMachine.make(new CoffeeOrder(0, true), COFFEE_PRICE);

        verify(coffeeMaker).execute("Ch::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_a_chocolate_order() {
        coffeeMachine.make(new ChocolateOrder(0, false), CHOCOLATE_PRICE);

        verify(coffeeMaker).execute("H::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_an_extra_hot_chocolate_order() {
        coffeeMachine.make(new ChocolateOrder(0, true), CHOCOLATE_PRICE);

        verify(coffeeMaker).execute("Hh::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_an_orange_juice_order() {
        coffeeMachine.make(new OrangeJuiceOrder(), ORANGE_JUICE_PRICE);

        verify(coffeeMaker).execute("O::");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_order_with_one_sugar() {
        coffeeMachine.make(new ChocolateOrder(1, false), CHOCOLATE_PRICE);

        verify(coffeeMaker).execute("H:1:0");
    }

    @Test
    public void should_send_command_to_coffee_maker_for_order_with_two_sugar() {
        coffeeMachine.make(new TeaOrder(2, false), TEA_PRICE);

        verify(coffeeMaker).execute("T:2:0");
    }

    @Test
    public void should_send_not_enough_money_command() {
        BigDecimal payment = TEA_PRICE.subtract(new BigDecimal("0.1"));

        coffeeMachine.make(new TeaOrder(0, false), payment);

        verify(coffeeMaker).execute("M:Not enough money. Missing 0.1 euros");
    }

    @Test
    public void should_save_order_when_is_served() {
        TeaOrder order = new TeaOrder(0, false);

        coffeeMachine.make(order, TEA_PRICE);

        verify(orderRepository).save(order);
    }
}
