package com.tmoreno.kata.coffeemachine;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.verify;

public class ReportServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ReportWriter reportWriter;

    @InjectMocks
    private ReportService reportService;

    @Test
    public void should_print_empty_when_there_are_not_saved_orders() {
        Report emptyReport = new Report();

        reportService.execute();

        verify(reportWriter).write(emptyReport);
    }
}
