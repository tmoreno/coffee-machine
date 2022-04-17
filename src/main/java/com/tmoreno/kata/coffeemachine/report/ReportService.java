package com.tmoreno.kata.coffeemachine.report;

import com.tmoreno.kata.coffeemachine.OrderRepository;

public final class ReportService {

    private final OrderRepository orderRepository;
    private final ReportWriter reportWriter;

    public ReportService(OrderRepository orderRepository, ReportWriter reportWriter) {
        this.orderRepository = orderRepository;
        this.reportWriter = reportWriter;
    }

    public void execute() {
        reportWriter.write(new Report());
    }
}
