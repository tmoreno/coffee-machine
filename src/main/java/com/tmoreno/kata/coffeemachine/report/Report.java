package com.tmoreno.kata.coffeemachine.report;

import java.math.BigDecimal;
import java.util.Objects;

public final class Report {

    private int teaSold;
    private int coffeeSold;
    private int chocolateSold;
    private int orangeSold;
    private BigDecimal totalEarned;

    public Report() {
        teaSold = 0;
        coffeeSold = 0;
        chocolateSold = 0;
        orangeSold = 0;
        totalEarned = BigDecimal.ZERO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        return teaSold == report.teaSold
                && coffeeSold == report.coffeeSold
                && chocolateSold == report.chocolateSold
                && orangeSold == report.orangeSold
                && totalEarned.equals(report.totalEarned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teaSold, coffeeSold, chocolateSold, orangeSold, totalEarned);
    }
}
