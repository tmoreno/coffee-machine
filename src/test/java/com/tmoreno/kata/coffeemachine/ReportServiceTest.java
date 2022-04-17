package com.tmoreno.kata.coffeemachine;

import com.tmoreno.kata.coffeemachine.report.Report;
import com.tmoreno.kata.coffeemachine.report.ReportService;
import com.tmoreno.kata.coffeemachine.report.ReportWriter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ReportWriter reportWriter;

    @InjectMocks
    private ReportService reportService;

    @Test
    public void should_generate_an_empty_report_when_there_are_not_saved_orders() {
        Report emptyReport = new Report(0, 0, 0, 0, BigDecimal.ZERO);

        reportService.execute();

        verify(reportWriter).write(emptyReport);
    }

    @Test
    public void should_write_report_for_different_orders_for_each_drink() {
        when(orderRepository.get())
            .thenReturn(List.of(
                new ChocolateOrder(0, false),
                new ChocolateOrder(0, false),
                new ChocolateOrder(0, false),
                new ChocolateOrder(0, false),
                new CoffeeOrder(0, false),
                new CoffeeOrder(0, false),
                new CoffeeOrder(0, false),
                new OrangeJuiceOrder(),
                new OrangeJuiceOrder(),
                new TeaOrder(0, false)
            ));

        Report report = new Report(1, 3, 4, 2, new BigDecimal("5.4"));

        reportService.execute();

        verify(reportWriter).write(report);
    }
}
