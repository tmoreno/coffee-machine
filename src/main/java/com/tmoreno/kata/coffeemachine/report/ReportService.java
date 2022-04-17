package com.tmoreno.kata.coffeemachine.report;

import com.tmoreno.kata.coffeemachine.DrinkCode;
import com.tmoreno.kata.coffeemachine.Order;
import com.tmoreno.kata.coffeemachine.OrderRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class ReportService {

    private final OrderRepository orderRepository;
    private final ReportWriter reportWriter;

    public ReportService(OrderRepository orderRepository, ReportWriter reportWriter) {
        this.orderRepository = orderRepository;
        this.reportWriter = reportWriter;
    }

    public void execute() {
        Map<DrinkCode, AtomicInteger> drinksServed = Arrays.stream(DrinkCode.values())
            .collect(Collectors.toMap(
                e -> e,
                e -> new AtomicInteger()
            ));

        BigDecimal totalAmountServed = BigDecimal.ZERO;

        List<Order> orders = orderRepository.get();

        for (Order order : orders) {
            drinksServed.get(order.getDrinkCode()).incrementAndGet();

            totalAmountServed = totalAmountServed.add(order.getDrinkPrice());
        }

        Report report = new Report(
            drinksServed.get(DrinkCode.TEA).intValue(),
            drinksServed.get(DrinkCode.COFFEE).intValue(),
            drinksServed.get(DrinkCode.CHOCOLATE).intValue(),
            drinksServed.get(DrinkCode.ORANGE_JUICE).intValue(),
            totalAmountServed
        );

        reportWriter.write(report);
    }
}
