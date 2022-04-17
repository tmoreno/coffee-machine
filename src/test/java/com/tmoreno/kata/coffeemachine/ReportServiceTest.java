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

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ReportWriter reportWriter;

    @InjectMocks
    private ReportService reportService;

    @Test
    public void should_print_empty_when_there_are_not_saved_orders() {
        Report emptyReport = new Report(0, 0, 0, 0, BigDecimal.ZERO);

        reportService.execute();

        verify(reportWriter).write(emptyReport);
    }
}
