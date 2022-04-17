package com.tmoreno.kata.coffeemachine.report;

import com.tmoreno.kata.coffeemachine.Order;
import com.tmoreno.kata.coffeemachine.OrderRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class ReportService {

    private final OrderRepository orderRepository;
    private final ReportWriter reportWriter;

    public ReportService(OrderRepository orderRepository, ReportWriter reportWriter) {
        this.orderRepository = orderRepository;
        this.reportWriter = reportWriter;
    }

    public void execute() {
        List<Order> orders = orderRepository.get();

        Map<String, AtomicInteger> drinkServed = new HashMap<>();
        BigDecimal totalAmountServed = BigDecimal.ZERO;

        for (Order order : orders) {
            drinkServed.computeIfAbsent(order.getDrinkCode(), k -> new AtomicInteger())
                    .incrementAndGet();

            totalAmountServed = totalAmountServed.add(order.getDrinkPrice());
        }

        Report report = new Report(
            drinkServed.getOrDefault("T", new AtomicInteger()).intValue(),
            drinkServed.getOrDefault("C", new AtomicInteger()).intValue(),
            drinkServed.getOrDefault("H", new AtomicInteger()).intValue(),
            drinkServed.getOrDefault("O", new AtomicInteger()).intValue(),
            totalAmountServed
        );

        reportWriter.write(report);
    }
}
