package com.tmoreno.kata.coffeemachine.report;

import com.tmoreno.kata.coffeemachine.OrderRepository;

import java.math.BigDecimal;

public final class ReportService {

    private final OrderRepository orderRepository;
    private final ReportWriter reportWriter;

    public ReportService(OrderRepository orderRepository, ReportWriter reportWriter) {
        this.orderRepository = orderRepository;
        this.reportWriter = reportWriter;
    }

    public void execute() {
        reportWriter.write(new Report(0, 0, 0, 0, BigDecimal.ZERO));
    }
}
