package com.tmoreno.kata.coffeemachine;

import java.util.List;

public interface OrderRepository {

    void save(Order order);

    List<Order> get();
}
